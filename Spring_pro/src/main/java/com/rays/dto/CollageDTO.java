package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_COLLAGE")
public class CollageDTO extends BaseDTO{
	@Column(name = "NAME", length = 50)
	private String name;
	@Column(name = "address", length = 50)
	private String address;
	@Column(name = "state", length = 50)
	private String state;
	@Column(name = "city", length = 50)
	private String city;
	@Column(name = "phoneNo", length = 50)
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
	public String getValue() {
		return null;
	}
	
	
	

}
