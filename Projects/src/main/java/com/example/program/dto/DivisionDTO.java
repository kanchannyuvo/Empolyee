package com.example.program.dto;

import java.io.Serializable;

public class DivisionDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String divisionName;
	
	private String business;
	
	private String headName;


	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getHeadName() {
		return headName;
	}

	public void setHeadName(String headName) {
		this.headName = headName;
	}

	public DivisionDTO(String divisionName, String business, String headName) {
		super();
		this.divisionName = divisionName;
		this.business = business;
		this.headName = headName;
	}
	
	

}
