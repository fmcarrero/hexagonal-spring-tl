package com.example.application.configuration;

import com.example.core.adapters.PersonAdapter;
import com.example.core.ports.PersonRepository;
import com.example.core.ports.RabbitTemplateCustom;
import com.example.core.ports.People;
import com.example.jpa.PersonRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration  {

    @Bean
    public People personService(PersonRepository modelRepository ,RabbitTemplateCustom rabbitTemplate) {
        return new PersonAdapter(modelRepository,rabbitTemplate);
    }

    @Bean
    public PersonRepository modelRepository() {
        return new PersonRepositoryImpl();
    }


}
