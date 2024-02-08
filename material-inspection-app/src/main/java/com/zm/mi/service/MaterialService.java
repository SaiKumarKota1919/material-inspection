package com.zm.mi.service;

import java.util.List;

import com.zm.mi.entity.Material;

public interface MaterialService {

	void saveMaterial(Material material);

	boolean isAlreadyExists(Material material);

	List<Material> searchMaterial(Material material);

	Material getMaterialById(String materialId);

	void deleteMaterialById(String materialId);

	List<Material> getAllMaterials();
}