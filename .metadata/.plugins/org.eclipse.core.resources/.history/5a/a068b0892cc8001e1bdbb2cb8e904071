package com.zm.mi.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "userId")
	@SequenceGenerator(sequenceName = "userIdSeq",name = "userId",initialValue = 2001,allocationSize = 1)
	private Integer userId;
	private String userName;
	private String password;
	private LocalDate createdOn;
	private LocalDate updataedOn;
	private Integer createdBy;
	private Integer updatedBy;
	@OneToMany(mappedBy = "user")
	@ToString.Exclude
	private List<InspectionLot> inspectionLots;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDate getUpdataedOn() {
		return updataedOn;
	}
	public void setUpdataedOn(LocalDate updataedOn) {
		this.updataedOn = updataedOn;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public List<InspectionLot> getInspectionLots() {
		return inspectionLots;
	}
	public void setInspectionLots(List<InspectionLot> inspectionLots) {
		this.inspectionLots = inspectionLots;
	}
	
	

}
