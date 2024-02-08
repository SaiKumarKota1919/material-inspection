package com.zm.mi.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "isp_lot")
public class InspectionLot {
	@Id
	@Column(name = "lot_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "characterId")
	@SequenceGenerator(sequenceName = "characterId",name = "characterId",initialValue = 2001,allocationSize = 1)
	private Integer lotId;
	@ManyToOne
	@JoinColumn(name = "mat_id",nullable = false)
	private Material material;
	@ManyToOne
	@JoinColumn(name = "vend_id",nullable = false)
	private Vendor vendor;
	@ManyToOne
	@JoinColumn(name = "plant_id",nullable = false)
	private Plant plant;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	private LocalDate createdOn;
	private LocalDate startDate;
	private LocalDate endDate;
	private String result;
	private String remarks;
	@OneToMany(mappedBy = "inspectionLot")
	private List<InspectionActuals> inspectionActuals;
	public Integer getLotId() {
		return lotId;
	}
	public void setInspectionId(Integer inspectionId) {
		this.lotId = inspectionId;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public Plant getPlant() {
		return plant;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public List<InspectionActuals> getInspectionActuals() {
		return inspectionActuals;
	}
	public void setInspectionActuals(List<InspectionActuals> inspectionActuals) {
		this.inspectionActuals = inspectionActuals;
	}
	
	
	
	
}