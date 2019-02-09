package com.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entities.JpaPerson;

public interface JpaPersonRepository extends JpaRepository<JpaPerson, Long> {
}
