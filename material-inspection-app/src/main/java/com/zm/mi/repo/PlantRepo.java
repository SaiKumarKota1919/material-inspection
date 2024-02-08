package com.zm.mi.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zm.mi.entity.Plant;
@Repository
public interface PlantRepo extends JpaRepository<Plant,Serializable> {

}
