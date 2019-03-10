package com.ceiba.demo.infrastructure.controller.springcontroller.integration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.ceiba.demo.builder.PersonTestDataBuilder;
import com.ceiba.demo.domain.model.Person;
import com.ceiba.demo.infrastructure.application.springapp.Application;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@TestPropertySource(properties = { "spring.config.location = classpath:application-test.yml" })
@AutoConfigureMockMvc

public class PersonRestControllerTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Transactional
	@Rollback(true)
	@Test
	
	public void savePersonYoungTest() throws Exception {
		// arrange
		int id = 3;
		ObjectMapper mapper = new ObjectMapper();
		Person person = new PersonTestDataBuilder().withId(id).withlastName("carrero").withAge(4).withName("mauro")
				.build();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/people")
				.content(mapper.writeValueAsString(person)).contentType(MediaType.APPLICATION_JSON);

		// act
		mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isCreated())
				.andExpect(jsonPath("name", equalTo("mauro")));

	}

	@Transactional
	@Rollback(true)
	@Test
	public void savePersonAdultTest() throws Exception {
		// arrange
		int id = 10;
		ObjectMapper mapper = new ObjectMapper();
		Person person = new PersonTestDataBuilder().withId(id).withlastName("contreras").withAge(56)
				.withName("franklin").build();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/people")
				.content(mapper.writeValueAsString(person)).contentType(MediaType.APPLICATION_JSON);

		// act
		mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isCreated())
				.andExpect(jsonPath("name", equalTo("franklin")));

	}

	@Transactional
	@Rollback(true)
	@Test
	@SqlGroup({
			@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:integration/beforesavepeople2.sql"),
			@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:integration/aftersavepeople2.sql") })

	public void getPeopleTest() throws Exception {
		// arrange

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/people").contentType(MediaType.APPLICATION_JSON);
		// act
		mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", equalTo(1000))).andExpect(jsonPath("$[1].id", equalTo(2000)));
	}

	@Transactional
	@Rollback(true)
	@Test
	@SqlGroup({
			@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:integration/beforesavepeople.sql"),
			@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:integration/aftersavepeople.sql") })

	public void getPersonTest() throws Exception {
		// arrange

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/people/5000")
				.contentType(MediaType.APPLICATION_JSON);
		// act
		mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("name", equalTo("pedro"))).andExpect(jsonPath("lastName", equalTo("gonzalez")));
	}

	@Transactional
	@Rollback(true)
	@Test()
	public void getPersonNotFoundTest() throws Exception {
		// arrange

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/people/909855")
				.contentType(MediaType.APPLICATION_JSON);
		// act
		mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isNotFound());

	}

}
