package com.ceiba.demo.infrastructure.adapter.repository.dbsimple.jpaentity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.ceiba.demo.domain.model.Person;

@Entity(name = "person")
public class JpaPerson extends Person {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6702324315358553121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
	@NotNull
    private String name;
    
	@NotNull
    private String lastName;
    
    private int age;
    

    public long getId() {
        return id;
    }

    
    public String getName() {
        return name;
    }

    
    public String getLastName() {
        return this.lastName;
    }

    
    public int getAge() {
        return this.age;
    }    
    
    
     
    public void setId(long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public JpaPerson() {}
    
}
