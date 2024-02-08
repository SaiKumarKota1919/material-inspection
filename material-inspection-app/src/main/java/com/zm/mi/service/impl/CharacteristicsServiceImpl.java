package com.zm.mi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.mi.entity.MaterialCharacteristics;
import com.zm.mi.repo.MaterialCharRepo;
import com.zm.mi.service.CharacteristicsService;
@Service
public class CharacteristicsServiceImpl implements CharacteristicsService{
@Autowired
private MaterialCharRepo materialCharRepo;
	@Override
	public void addAllCharacteristics(List<MaterialCharacteristics> characteristicsList) {
		
			materialCharRepo.saveAll(characteristicsList);
		
	}
	@Override
	public MaterialCharacteristics getCharacterByid(Integer characterId) {
	    Optional<MaterialCharacteristics> character	= materialCharRepo.findById(characterId);
	    if(character.isPresent())
	    {
	    	return character.get();
	    }
		return null;
	}
	@Override
	public void updateCharacter(MaterialCharacteristics materialCharacteristics) {
		
		materialCharRepo.save(materialCharacteristics);
		
	}
	@Override
	public void deleteCharacterById(Integer characterId) {

		
		materialCharRepo.deleteById(characterId);
		
	}

}
