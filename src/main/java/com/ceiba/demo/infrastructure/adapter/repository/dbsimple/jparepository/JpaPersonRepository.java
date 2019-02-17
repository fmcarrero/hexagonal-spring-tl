package com.ceiba.demo.infrastructure.adapter.repository.dbsimple.jparepository;

import com.ceiba.demo.infrastructure.adapter.repository.dbsimple.jpaentity.JpaPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPersonRepository extends JpaRepository<JpaPerson, Long> {
}

