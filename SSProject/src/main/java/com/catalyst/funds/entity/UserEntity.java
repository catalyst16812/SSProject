package com.catalyst.funds.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity // This tells Hibernate to make a table out of this class
public class UserEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	@Column(nullable = false, unique = true, length = 45)
	private String userName;
	@Column(nullable = false, length = 45)
	private String email;
	@Column(nullable = false, length = 10)
	private Long phoneNo;
	@Column(nullable = false, length = 64)
	private String password;
	
	private String role;
	
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@ManyToMany(mappedBy = "userEntities")
	private Set<TeamsEntity> teamEntities;
	
	@OneToMany(mappedBy = "userEntity")
	private Set<PaymentEntity> paymentEntities;


public Set<PaymentEntity> getPaymentEntities() {
		return paymentEntities;
	}

	public void setPaymentEntities(Set<PaymentEntity> paymentEntities) {
		this.paymentEntities = paymentEntities;
	}

public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer id) {
    this.userId = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String name) {
    this.userName = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public Long getPhoneNo() {
	return phoneNo;
  }
  
  public void setPhoneNo(Long phoneNo) {
	this.phoneNo = phoneNo;
  }

  public Set<TeamsEntity> getTeamEntities() {
		return teamEntities;
	}

	public void setTeamEntities(Set<TeamsEntity> teamEntities) {
		this.teamEntities = teamEntities;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}

//same