package com.zm.mi.service;

import java.util.List;

import com.zm.mi.entity.InspectionLot;
import com.zm.mi.serachcriteria.LotSearchCriteria;

public interface LotService {

	void addLot(InspectionLot lot);

	List<InspectionLot> getLotsByLotSearchCriteria(LotSearchCriteria lotSearchCriteria);

	InspectionLot getLotById(Integer lotId);
	
}
