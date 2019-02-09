package com.example.application.configuration;

import com.example.core.adapters.PersonAdapter;
import com.example.core.adapters.PersonMaker;
import com.example.core.ports.PersonRepository;
import com.example.core.ports.ApplicationConfigReader;
import com.example.core.ports.MessageSender;
import com.example.core.ports.People;
import com.example.jpa.PersonRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public People personService(PersonRepository modelRepository, PersonMaker personMaker, MessageSender messageSender,
			ApplicationConfigReader applicationConfig) {
		return new PersonAdapter(modelRepository, personMaker, messageSender, applicationConfig);
	}

	@Bean
	public PersonRepository modelRepository() {
		return new PersonRepositoryImpl();
	}

}
