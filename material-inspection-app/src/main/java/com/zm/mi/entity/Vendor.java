package com.zm.mi.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "vendor")
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "vendorId")
	@SequenceGenerator(name = "vendorId",sequenceName = "vendorId",
	initialValue = 10001,allocationSize = 1)
	@Column(name = "vend_id")
	private Integer vendorId;
	@Column(unique = true,name = "vend_name",length = 100)
	private String vendorName;
	@Column(name = "vend_contact")
	private Long vendorContact;
	@Column(name="vend_loc")
	private String vendorLocation;
	@Column(name="vend_status",length = 10)
	private String vendorStatus;
	@OneToMany(mappedBy = "vendor")
	private List<InspectionLot> inspectionLots;
	public Integer getVendorId() {
		return vendorId;
	}
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Long getVendorContact() {
		return vendorContact;
	}
	public void setVendorContact(Long vendorContact) {
		this.vendorContact = vendorContact;
	}
	public String getVendorLocation() {
		return vendorLocation;
	}
	public void setVendorLocation(String vendorLocation) {
		this.vendorLocation = vendorLocation;
	}
	public String getVendorStatus() {
		return vendorStatus;
	}
	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}
	public List<InspectionLot> getInspectionLots() {
		return inspectionLots;
	}
	public void setInspectionLots(List<InspectionLot> inspectionLots) {
		this.inspectionLots = inspectionLots;
	}
	
	
	@Override
	public String toString() {
	    return String.valueOf(vendorId);
	}

}