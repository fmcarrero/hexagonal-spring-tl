package com.ceiba.demo.infrastructure.application.springapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.demo.domain.ports.PersonRepository;
import com.ceiba.demo.infrastructure.adapter.repository.dbsimple.db.MysqlPersonRepository;
import com.ceiba.demo.infrastructure.adapter.repository.dbsimple.jparepository.JpaPersonRepository;

@Configuration
public class JpaConfiguration {
	
    @Bean
    public PersonRepository personRepository(JpaPersonRepository jpaPersonRepository) {
        return new MysqlPersonRepository(jpaPersonRepository );
    }
 
}
