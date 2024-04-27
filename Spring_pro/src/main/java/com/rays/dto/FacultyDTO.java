package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;
@Entity
@Table(name="ST_FACULTY")
public class FacultyDTO extends BaseDTO{
	@Column(name="FIRST_NAME",length = 50)
	private String firstName;
	
	@Column(name="LAST_NAME",length = 50)
	private String lastName;
	
	@Column(name="DOB",length = 50)
	private Date dob;
	
	@Column(name="GENDER",length = 50)
	private String  gender ;
	
	@Column(name="PHONENO",length = 50)
	private String phoneNo;
	
	@Column(name="QUALIFICATION",length = 50)
	private String qualification;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
