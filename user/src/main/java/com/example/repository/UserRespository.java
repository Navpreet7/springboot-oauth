package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.UserDetails;

@Repository
public interface UserRespository extends JpaRepository<UserDetails,String>{
    
}
