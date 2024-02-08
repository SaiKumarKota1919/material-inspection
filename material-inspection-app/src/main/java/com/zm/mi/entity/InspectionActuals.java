package com.zm.mi.entity;

import com.zm.mi.model.InspectionActualsId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "mat_isp_act")
@IdClass(InspectionActualsId.class)
public class InspectionActuals {
	@Id
	@ManyToOne
	@JoinColumn(name = "lot_id")
	private InspectionLot inspectionLot;
	@Id
	@ManyToOne
	@JoinColumn(name = "ch_id",referencedColumnName = "ch_id")
	private MaterialCharacteristics materialCharacteristics;
	@Column(name = "max_mes",nullable = false)
	private Float maxMeasurement;
	@Column(name = "min_mes",nullable = false)
	private Float minMeasurement;
	public InspectionLot getInspectionLot() {
		return inspectionLot;
	}
	public void setInspectionLot(InspectionLot inspectionLot) {
		this.inspectionLot = inspectionLot;
	}
	public MaterialCharacteristics getMaterialCharacteristics() {
		return materialCharacteristics;
	}
	public void setMaterialCharacteristics(MaterialCharacteristics materialCharacteristics) {
		this.materialCharacteristics = materialCharacteristics;
	}
	public Float getMaxMeasurement() {
		return maxMeasurement;
	}
	public void setMaxMeasurement(Float maxMeasurement) {
		this.maxMeasurement = maxMeasurement;
	}
	public Float getMinMeasurement() {
		return minMeasurement;
	}
	public void setMinMeasurement(Float minMeasurement) {
		this.minMeasurement = minMeasurement;
	}
	
	
	

}
