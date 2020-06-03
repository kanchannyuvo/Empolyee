package com.example.program.model;

import java.io.Serializable;

public class DivisionCount implements Serializable {
	

	private static final long serialVersionUID = 1L;

	private int divisionId;
	
	private Long empTotalCount;

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public Long getEmpTotalCount() {
		return empTotalCount;
	}

	public void setEmpTotalCount(Long empTotalCount) {
		this.empTotalCount = empTotalCount;
	}

	public DivisionCount(int divisionId, Long empTotalCount) {
		super();
		this.divisionId = divisionId;
		this.empTotalCount = empTotalCount;
	}

}
