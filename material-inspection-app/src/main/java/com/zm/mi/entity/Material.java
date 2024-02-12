package com.zm.mi.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor
@Table(name = "Material")
public class Material {
	@Id
	@Column(name = "mat_id",length=20)
	private String materialId;
	@Column(name="mat_desc")
	private String materialDesc;
	@Column(name = "mat_type",length =100)
	private String materialType;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "material",fetch = FetchType.EAGER)
	private List<MaterialCharacteristics> materialCharacteristics;
	@OneToMany(mappedBy = "material")
	private List<InspectionLot> inspectionLots;

	public Material(String materialDesc, String materialType) {
		super();
		this.materialDesc = materialDesc;
		this.materialType = materialType;
	
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getMaterialDesc() {
		return materialDesc;
	}

	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public List<MaterialCharacteristics> getMaterialCharacteristics() {
		
		return materialCharacteristics;
	}

	public void setMaterialCharacteristics(List<MaterialCharacteristics> materialCharacteristics) {
		this.materialCharacteristics = materialCharacteristics;
	}

	public List<InspectionLot> getInspectionLots() {
		return inspectionLots;
	}

	public void setInspectionLots(List<InspectionLot> inspectionLots) {
		this.inspectionLots = inspectionLots;
	}

}
