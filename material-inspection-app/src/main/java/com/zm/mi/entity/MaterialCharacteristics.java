package com.zm.mi.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MAT_ISP_CH")
public class MaterialCharacteristics {
	
	@Id
	@Column(name ="ch_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "characterId")
	@SequenceGenerator(sequenceName = "characterId",name = "character_seq",initialValue = 1001,allocationSize = 1)
	private Integer characterId;
	@Column(name = "ch_desc")
	private String  characterDesc;
	@ManyToOne(targetEntity= Material.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "mat_id")
	private Material material;
	@Column(name = "tol_ul")
	private Float upperTolLimit;
	@Column(name = "tol_ll")
	private Float lowerTolLimit;
	@Column(name = "uom",length = 8)
	private String unitsOfMsrmnt;
	@OneToMany(mappedBy = "materialCharacteristics")
	private List<InspectionActuals> inspectionActuals=new ArrayList<>();
	public Integer getCharacterId() {
		return characterId;
	}
	public void setCharacterId(Integer characterId) {
		this.characterId = characterId;
	}
	public String getCharacterDesc() {
		return characterDesc;
	}
	public void setCharacterDesc(String characterDesc) {
		this.characterDesc = characterDesc;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Float getUpperTolLimit() {
		return upperTolLimit;
	}
	public void setUpperTolLimit(Float upperTolLimit) {
		this.upperTolLimit = upperTolLimit;
	}
	public Float getLowerTolLimit() {
		return lowerTolLimit;
	}
	public void setLowerTolLimit(Float lowerTolLimit) {
		this.lowerTolLimit = lowerTolLimit;
	}
	public String getUnitsOfMsrmnt() {
		return unitsOfMsrmnt;
	}
	public void setUnitsOfMsrmnt(String unitsOfMsrmnt) {
		this.unitsOfMsrmnt = unitsOfMsrmnt;
	}
	public List<InspectionActuals> getInspectionActuals() {
		return inspectionActuals;
	}
	public void setInspectionActuals(List<InspectionActuals> inspectionActuals) {
		this.inspectionActuals = inspectionActuals;
	}

	
	
}
