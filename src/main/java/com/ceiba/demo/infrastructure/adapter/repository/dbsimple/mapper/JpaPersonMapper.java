package com.ceiba.demo.infrastructure.adapter.repository.dbsimple.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.ceiba.demo.domain.model.Person;
import com.ceiba.demo.infrastructure.adapter.repository.dbsimple.jpaentity.JpaPerson;

@Mapper
public interface JpaPersonMapper {

    JpaPersonMapper MAPPER = Mappers.getMapper(JpaPersonMapper.class);

    Person toPerson(JpaPerson jpaPerson);

    List<Person> toPeople(List<JpaPerson> jpaPeoples);

    JpaPerson toJpaPerson(Person person);
}
