package com.catalyst.funds.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity // This tells Hibernate to make a table out of this class
public class TeamsEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer teamId;
  
	private String teamName;
	
	private Long fundGoal;
	
	private String cycle;
	
	
	@ManyToMany
	@JoinTable(name="TeamWithUser",joinColumns = @JoinColumn(name = "team_id"),inverseJoinColumns = @JoinColumn(name="user_id"))
	private Set<UserEntity> userEntities;
	
	
	@ManyToMany(mappedBy = "teamsEntitiy")
	private Set<PaymentEntity> paymentEntities;


public Set<PaymentEntity> getPaymentEntities() {
		return paymentEntities;
	}

	public void setPaymentEntities(Set<PaymentEntity> paymentEntities) {
		this.paymentEntities = paymentEntities;
	}

	
  public Integer getTeamId() {
    return teamId;
  }

  public void setTeamId(Integer teamId) {
    this.teamId = teamId;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }
  
  public Long getFundGoal() {
	 return fundGoal;
  }
  
  public void setFundGoal(Long fundGoal) {
	 this.fundGoal = fundGoal;
  }

public String getCycle() {
	 return cycle;
  }
  
  public void setCycle(String cycle) {
	 this.cycle = cycle;
  }
  
  
  public Set<UserEntity> getUserEntities() {
	return userEntities;
}

public void setUserEntities(Set<UserEntity> userEntities) {
	this.userEntities = userEntities;
}
 
}