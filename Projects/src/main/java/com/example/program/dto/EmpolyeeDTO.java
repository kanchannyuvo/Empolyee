package com.example.program.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class EmpolyeeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private BigDecimal salary;
	

	public EmpolyeeDTO(BigDecimal salary, String bankAccountName, String employeeName, String managerName,
			int divisionId) {
		super();
		this.salary = salary;
		this.bankAccountName = bankAccountName;
		this.employeeName = employeeName;
		this.managerName = managerName;
		this.divisionId = divisionId;
	}


	private String bankAccountName;
	

	private String employeeName;
	

	private String  managerName;
	

	private int divisionId;


	public BigDecimal getSalary() {
		return salary;
	}


	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}


	public String getBankAccountName() {
		return bankAccountName;
	}


	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getManagerName() {
		return managerName;
	}


	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	public int getDivisionId() {
		return divisionId;
	}


	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

}
