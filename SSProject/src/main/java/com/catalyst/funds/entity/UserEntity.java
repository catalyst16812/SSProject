package com.catalyst.funds.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;



@Entity // This tells Hibernate to make a table out of this class
public class UserEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	@Column(nullable = false, unique = true)
	private String userName;

	private String email;
	
	private Long phoneNo;
	
	private String password;
	
//	private String role;
//	
//	
//	
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "userId") },
            inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }
    )
    private List<RoleEntity> roles = new ArrayList<>();

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
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