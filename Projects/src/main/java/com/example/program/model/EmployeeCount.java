package com.example.program.model;

import java.io.Serializable;

public class EmployeeCount implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String managerName;
	
	private Long empTotalCount;
	
	

	public EmployeeCount(String managerName, Long total) {
		super();
		this.managerName = managerName;
		this.empTotalCount = total;
	}
	

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Long getTotal() {
		return empTotalCount;
	}

	public void setTotal(Long total) {
		this.empTotalCount = total;
	}


	
	

}
