package com.zm.mi.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plant")
public class Plant {
	
	@Id
	@Column(name = "plant_id")
	private String plantId;
	@Column(name = "plant_name")
	private String plantName;
	@Column(name = "city",length = 50)
	private String plantCity;
	@Column(name = "state",length = 50)
	private String plantState;
	@Column(name = "status",length = 10)
	private String plantStatus;
	@Column(name = "contact_no")
	private Integer plantContanctNo;
	@OneToMany(mappedBy = "plant")
	@ToString.Exclude
	private List<InspectionLot> inspectionLots;
	public String getPlantId() {
		return plantId;
	}
	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public String getPlantCity() {
		return plantCity;
	}
	public void setPlantCity(String plantCity) {
		this.plantCity = plantCity;
	}
	public String getPlantState() {
		return plantState;
	}
	public void setPlantState(String plantState) {
		this.plantState = plantState;
	}
	public String getPlantStatus() {
		return plantStatus;
	}
	public void setPlantStatus(String plantStatus) {
		this.plantStatus = plantStatus;
	}
	public Integer getPlantContanctNo() {
		return plantContanctNo;
	}
	public void setPlantContanctNo(Integer plantContanctNo) {
		this.plantContanctNo = plantContanctNo;
	}
	public List<InspectionLot> getInspectionLots() {
		return inspectionLots;
	}
	public void setInspectionLots(List<InspectionLot> inspectionLots) {
		this.inspectionLots = inspectionLots;
	}
	
	

}
