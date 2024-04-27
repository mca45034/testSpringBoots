package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.EmployeDTO;

public class EmployeForm extends BaseForm{
	@NotEmpty(message = "firstName is required")
	private String name;
	
	@NotEmpty(message = "department is required")
	private String department;
	
	@NotEmpty(message = "address is required")
	private String address;
	
	
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
	public BaseDTO getDto() {
		EmployeDTO dto=initDTO(new EmployeDTO());
		dto.setName(name);
		dto.setDepartment(department);
		dto.setAddress(address);
		dto.setSalary(salary);
		return dto;
		
	}

	

}
