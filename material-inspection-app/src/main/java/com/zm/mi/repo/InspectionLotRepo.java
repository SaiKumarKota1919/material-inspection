package com.zm.mi.repo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zm.mi.entity.InspectionLot;

public interface InspectionLotRepo extends JpaRepository<InspectionLot, Serializable> {

	List<InspectionLot> findAllByCreatedOnBetween(LocalDate fromDate,LocalDate toDate);
	
	//@Query("select * from isp_lot WHERE (:lotId IS NULL OR lot_id=:lotId) AND (:mid IS NULL OR mat_id=:mid) ")
	//List<InspectionLot> findAllByCreatedOnBetween1(Integer lotId, String mid, String pid, String status,LocalDate fromDate,LocalDate toDate);
	
}
