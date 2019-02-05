package com.example.core.domain;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.core.ports.ApplicationConfigReader;

public class Young extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationConfigReader applicationConfig;
	
	@Autowired
	public void setApplicationConfig(ApplicationConfigReader applicationConfig) {
		this.applicationConfig = applicationConfig;
	}
	
	@Override
	public String GetNameExchange() {
		return this.applicationConfig.getApp1Exchange();
	}

}
