package com.example.core.domain;


public class Young extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Young() {}
	

	private String appRoutingKey;
	
	public void setAppRoutingKey(String appRoutingKey) {
		this.appRoutingKey = appRoutingKey;
	}
	
	
	@Override
	public String GetRoutingKey() {
		return this.appRoutingKey;
	}
	
	public Young(Long id, String name, String lastName,int age) {
		super(id,name,lastName, age);        
    }


}
