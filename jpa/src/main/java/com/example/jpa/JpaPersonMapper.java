package com.example.jpa;

import com.example.core.domain.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JpaPersonMapper {

    JpaPersonMapper MAPPER = Mappers.getMapper(JpaPersonMapper.class);

    Person toPerson(JpaPerson jpaPerson);

    List<Person> toPeople(List<JpaPerson> jpaPeoples);

    JpaPerson toJpaPerson(Person person);
}
