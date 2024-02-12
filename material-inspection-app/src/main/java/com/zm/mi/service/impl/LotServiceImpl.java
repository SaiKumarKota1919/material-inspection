package com.zm.mi.service.impl;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zm.mi.entity.InspectionActuals;
import com.zm.mi.entity.InspectionLot;
import com.zm.mi.entity.Material;
import com.zm.mi.entity.MaterialCharacteristics;
import com.zm.mi.entity.User;
import com.zm.mi.model.ActualsAndExpected;
import com.zm.mi.repo.InspectionLotRepo;
import com.zm.mi.serachcriteria.LotSearchCriteria;
import com.zm.mi.service.InspectionActualsService;
import com.zm.mi.service.LotService;
import com.zm.mi.utils.StringDataUtils;
@Service
public class LotServiceImpl implements LotService
{
	@Autowired
	private InspectionLotRepo lotRepo;
	@Autowired
	private InspectionActualsService inspectionActualsService;
	@Value("${lot.date.search.range}")
	private Integer noOfDays; 
	@Override
	public void addLot(InspectionLot lot) {
		
		lotRepo.save(lot);

	}

	@Override
	public List<InspectionLot> getLotsByLotSearchCriteria(LotSearchCriteria lotSearchCriteria) {
		
		
		
		List<InspectionLot> lots = new ArrayList<>();
		
		if(lotSearchCriteria.getLotId()==null)
		{
			lotSearchCriteria.setMaterialId(StringDataUtils.normlaizeString(lotSearchCriteria.getMaterialId()).toUpperCase());
			lotSearchCriteria.setPlantId(StringDataUtils.normlaizeString(lotSearchCriteria.getPlantId()).toUpperCase());
			lots  =	lotRepo.findAllByCreatedOnBetween(lotSearchCriteria.getFromDate(), 
						lotSearchCriteria.getToDate());
		}
	   
		else {
			
			InspectionLot inspectionLot = lotRepo.findById(lotSearchCriteria.getLotId()).orElse(null);
 			
			if(inspectionLot!=null)
			{
				lots.add(inspectionLot);
			}
		
			
			return lots;
			
		}
		
		
		
		
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
			
			
			
			if(lotSearchCriteria.getStatus().equals("UNDER PROCESS"))
			{
				System.out.println(lotSearchCriteria.getStatus());
				
				lots = lots.stream()
					    .filter(lot -> lot.getResult() == null || lot.getResult().equals(lotSearchCriteria.getStatus()))
					    .collect(Collectors.toList());
				System.out.println(lots);
			
				
				
			}
			else {
				lots = lots.stream()
					    .filter(lot -> lot.getResult() != null && lot.getResult().equals(lotSearchCriteria.getStatus()))
					    .collect(Collectors.toList());
			}
			
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

	@Override
	public ActualsAndExpected processInspection(InspectionLot inspectionLot) {
		
		ActualsAndExpected actualsAndExpected = new ActualsAndExpected();
		Material material = inspectionLot.getMaterial();
		
		actualsAndExpected.setMaterialId(material.getMaterialId());
		actualsAndExpected.setMaterialDesc(material.getMaterialDesc());
		actualsAndExpected.setMaterialType(material.getMaterialType());
		
		List<MaterialCharacteristics> materialCharacteristics = inspectionLot.getMaterial()
																	.getMaterialCharacteristics();
		
		List<InspectionActuals> inspectionActuals = inspectionActualsService.getAllByLotId(inspectionLot.getLotId());
		
		for(int i=0;i<materialCharacteristics.size();i++)
		{
			for(InspectionActuals insp : inspectionActuals)
			{
				if(materialCharacteristics.get(i).getCharacterId()==insp.getMaterialCharacteristics().getCharacterId())
				{
					actualsAndExpected.setUpperTolLimit(materialCharacteristics.get(i).getUpperTolLimit());
					actualsAndExpected.setLowerTolLimit(materialCharacteristics.get(i).getLowerTolLimit());
					actualsAndExpected.setMaxMeasurement(insp.getMaxMeasurement());
					actualsAndExpected.setMinMeasurement(insp.getMinMeasurement());
					
					
				}
				
			}
			
		}
		
		if(actualsAndExpected.getUpperTolLimit()>=actualsAndExpected.getMaxMeasurement()
										&& 
			actualsAndExpected.getLowerTolLimit()<=actualsAndExpected.getMinMeasurement())	
		{
			
			actualsAndExpected.setStatus("PASS");
			actualsAndExpected.setRemarks("SYSTEM ENTRY");
			inspectionLot.setResult("PASS");
			inspectionLot.setRemarks("SYSTEM ENTRY");
			lotRepo.save(inspectionLot);
			
			
		}
		else {
			
			
			actualsAndExpected.setStatus("ON HOLD");
			actualsAndExpected.setRemarks("SYSTEM ENTRY");
			inspectionLot.setResult("ON HOLD");
			inspectionLot.setRemarks("SYSTEM ENTRY");
			lotRepo.save(inspectionLot);
			
		}
		
		
		
		
		return actualsAndExpected;
	}

	@Override
	public boolean isValidDateRange(LotSearchCriteria lotSearchCriteria) {
		
		long diff = ChronoUnit.DAYS.between(lotSearchCriteria.getFromDate(), lotSearchCriteria.getToDate());
		
		
		
		if (diff<=noOfDays && diff>=0) {
			
			return true;
			
		}
		
		return false;
	}

}
