package com.example.program.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=11, name="emp_id")
	private int employeeId;
	
	@Column(length=100, name="salary")
	private BigDecimal salary;
	
	@Column(length=100, name="bank_acc_name")
	private String bankAccountName;
	
	@Column(length=100, name="emp_name")
	private String employeeName;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="manager_id",referencedColumnName = "emp_id")
	private Employee manager;
	
	@OneToOne
	@JoinColumn(name="division_id")
	private Division divisionId;

	

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

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

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Division getDivision_id() {
		return divisionId;
	}

	public void setDivision_id(Division division_id) {
		this.divisionId = division_id;
	}

}
