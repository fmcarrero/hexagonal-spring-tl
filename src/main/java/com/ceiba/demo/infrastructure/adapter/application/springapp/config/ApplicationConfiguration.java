package com.ceiba.demo.infrastructure.adapter.application.springapp.config;

import com.ceiba.demo.application.caseuse.CreatePerson;
import com.ceiba.demo.application.caseuse.FindPerson;
import com.ceiba.demo.infrastructure.adapter.repository.dbsimple.jparepository.JpaPersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ceiba.demo.domain.ports.PersonRepository;
import com.ceiba.demo.domain.ports.MessageSender;
import com.ceiba.demo.infrastructure.adapter.repository.dbsimple.db.MysqlPersonRepository;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public CreatePerson createPerson( MessageSender messageSender){
        return new CreatePerson(messageSender);
    }
    @Bean
    public FindPerson findPerson (PersonRepository personRepository){
        return  new FindPerson(personRepository);
    }

    @Bean
    public PersonRepository personRepository(JpaPersonRepository jpaPersonRepository) {
        return new MysqlPersonRepository(jpaPersonRepository );
    }

}
