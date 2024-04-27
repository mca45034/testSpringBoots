package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="ST_EMP")
public class EmployeDTO extends BaseDTO{
	@Column(name = "NAME", length = 50)
	private String name;
	
	@Column(name = "DEPARTMENT", length = 50)
	private String department;
	
	@Column(name = "ADDRESS", length = 50)
	private String address;
	
	@Column(name = "SALARY", length = 50)
	private int salary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
