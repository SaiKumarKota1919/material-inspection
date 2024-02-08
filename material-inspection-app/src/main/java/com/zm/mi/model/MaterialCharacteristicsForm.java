package com.zm.mi.model;

import java.util.List;

import com.zm.mi.entity.MaterialCharacteristics;

public class MaterialCharacteristicsForm {
    private List<MaterialCharacteristics> characteristicsList;

    // Add default constructor and any other methods if needed

    public List<MaterialCharacteristics> getCharacteristicsList() {
        return characteristicsList;
    }

    public void setCharacteristicsList(List<MaterialCharacteristics> characteristicsList) {
        this.characteristicsList = characteristicsList;
    }

	public MaterialCharacteristicsForm(List<MaterialCharacteristics> characteristicsList) {
		super();
		this.characteristicsList = characteristicsList;
	}

	public MaterialCharacteristicsForm() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}