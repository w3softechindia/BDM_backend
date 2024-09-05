package com.example.demo.Repoisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Role;

@Repository
public interface roleRepository extends JpaRepository<Role, String>{

}
