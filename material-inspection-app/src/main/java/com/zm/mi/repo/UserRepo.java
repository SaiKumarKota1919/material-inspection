package com.zm.mi.repo;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zm.mi.entity.User;

public interface UserRepo extends JpaRepository<User,Serializable>{
	
	Optional<User> findByUserNameAndPassword(String userName,String password);

}
