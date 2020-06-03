package com.example.program.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "division")
public class Division implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=11, name="division_id")
	private int division_id;
	
	@Column(length=100, name="name")
	private String divisionName;
	
	@Column(length=100, name="business")
	private String business;
	
	@OneToOne
	@JoinColumn(name="head_id")
	private Employee employee;

	public int getDivision_id() {
		return division_id;
	}

	public void setDivision_id(int division_id) {
		this.division_id = division_id;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
