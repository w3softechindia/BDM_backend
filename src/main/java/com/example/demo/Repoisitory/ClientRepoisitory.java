package com.example.demo.Repoisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Client;

@Repository
public interface ClientRepoisitory extends JpaRepository<Client, String> {

}
