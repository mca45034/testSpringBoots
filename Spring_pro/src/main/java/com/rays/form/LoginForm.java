package com.rays.form;

import javax.validation.constraints.NotEmpty;

public class LoginForm {
	@NotEmpty(message = "login is required")
	private String loginId;
	@NotEmpty(message = "password is required")
	private String password;
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
