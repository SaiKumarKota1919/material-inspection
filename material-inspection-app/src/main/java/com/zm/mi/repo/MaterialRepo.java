package com.zm.mi.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zm.mi.entity.Material;
@Repository
public interface MaterialRepo extends JpaRepository<Material, Serializable> {

	Material findByMaterialIdOrMaterialDesc(String materialId, String materialDesc);	
}
