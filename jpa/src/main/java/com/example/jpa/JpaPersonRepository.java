package com.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPersonRepository extends JpaRepository<JpaPerson, Long> {
}
