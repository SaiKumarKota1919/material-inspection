package com.zm.mi.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zm.mi.entity.InspectionActuals;
@Repository
public interface InspectionActualsRepo extends JpaRepository<InspectionActuals, Serializable>{

	@Query(value ="select * from mat_isp_act where lot_id=:lotId" ,nativeQuery = true)
	List<InspectionActuals> findAllByLotId(Integer lotId);
	@Query(value ="select * from mat_isp_act where ch_id in(:integers)" ,nativeQuery = true)
	List<InspectionActuals> findAllByMaterialCharacteristics(List<Integer> integers);
	
}