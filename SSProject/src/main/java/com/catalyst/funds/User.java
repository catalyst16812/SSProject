package com.catalyst.funds;

public class User {

	private String userName ;
	private long phoneNo ;
	private String email ;
	private int userId;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", phoneNo=" + phoneNo + ", email=" + email + ", userId=" + userId + "]";
	}
	
	
}
