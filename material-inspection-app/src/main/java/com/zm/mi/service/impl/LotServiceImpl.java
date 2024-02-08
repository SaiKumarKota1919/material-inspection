package com.zm.mi.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zm.mi.entity.InspectionLot;
import com.zm.mi.repo.InspectionLotRepo;
import com.zm.mi.serachcriteria.LotSearchCriteria;
import com.zm.mi.service.LotService;
@Service
public class LotServiceImpl implements LotService
{
	@Autowired
	private InspectionLotRepo lotRepo;
	
	
	@Override
	public void addLot(InspectionLot lot) {
		
		lotRepo.save(lot);

	}

	@Override
	public List<InspectionLot> getLotsByLotSearchCriteria(LotSearchCriteria lotSearchCriteria) {
		
	 List<InspectionLot> lots =	lotRepo.findAllByCreatedOnBetween(lotSearchCriteria.getFromDate(), 
			 														lotSearchCriteria.getToDate());
		System.out.println(lots);
		
		
		if(lotSearchCriteria.getLotId()!=null)
		{
			lots= lots.stream().filter(lot->lot.getLotId()==lotSearchCriteria.getLotId())
							.collect(Collectors.toList());
		}
		if(lotSearchCriteria.getMaterialId().length()!=0)
		{
			lots= lots.stream().filter(lot->lot.getMaterial()
												.getMaterialId().equals(lotSearchCriteria.getMaterialId()))
					.collect(Collectors.toList());
		}
		if(lotSearchCriteria.getPlantId().length()!=0)
		{
			lots = lots.stream().filter(lot->lot.getPlant()
												.getPlantId().equals(lotSearchCriteria.getPlantId()))
								.collect(Collectors.toList());
		}
		if(lotSearchCriteria.getStatus().length()!=0)
		{
			//lots = lots.stream().filter(lot->lot.getResult().equals(lotSearchCriteria.getStatus()))
				//				.collect(Collectors.toList());
		}
		
		
		return lots;
	}

	@Override
	public InspectionLot getLotById(Integer lotId) {
		Optional<InspectionLot> lotOptional = lotRepo.findById(lotId);
		if(lotOptional.isPresent())
		{
			return lotOptional.get();
		}
		
		return null;
	}

}
