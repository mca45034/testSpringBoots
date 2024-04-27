package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CollageDTO;

public class CollageForm extends BaseForm{
	@NotEmpty(message = "collage name is required..")
	private String name;
	
	@NotEmpty(message = "address is required..")
	private String address;
	
	@NotEmpty(message = "state is required..")
	private String state;
	
	@NotEmpty(message = "city is required..")
	private String city;
	
	@NotEmpty(message = "phoneNo is required..")
	private String phoneNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public BaseDTO getDto() {
		CollageDTO dto = initDTO(new CollageDTO());
		dto.setName(name);
		dto.setAddress(address);
		dto.setState(state);
		dto.setCity(city);
		dto.setPhoneNo(phoneNo);
		return dto;
	}
	

}
