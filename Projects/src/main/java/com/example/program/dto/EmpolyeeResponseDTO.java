package com.example.program.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class EmpolyeeResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private BigDecimal salary;


	private String bankAccountName;


	private String employeeName;


	private String  managerName;


	private int divisionId;

	
	private int employeeId;

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



	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankAccountName == null) ? 0 : bankAccountName.hashCode());
		result = prime * result + divisionId;
		result = prime * result + employeeId;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((managerName == null) ? 0 : managerName.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpolyeeResponseDTO other = (EmpolyeeResponseDTO) obj;
		if (bankAccountName == null) {
			if (other.bankAccountName != null)
				return false;
		} else if (!bankAccountName.equals(other.bankAccountName))
			return false;
		if (divisionId != other.divisionId)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (managerName == null) {
			if (other.managerName != null)
				return false;
		} else if (!managerName.equals(other.managerName))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmpolyeeResponseDTO [salary=" + salary + ", bankAccountName=" + bankAccountName + ", employeeName="
				+ employeeName + ", managerName=" + managerName + ", divisionId=" + divisionId + ", employeeId="
				+ employeeId + "]";
	}
	


}
