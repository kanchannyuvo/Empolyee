package com.example.program.dto;

import java.io.Serializable;

public class DivisionResponseDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String divisionName;
	
	private String business;
	
	private String headName;
	
	private int divisionId;
	
	private String message;
	
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

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
	
	

}
