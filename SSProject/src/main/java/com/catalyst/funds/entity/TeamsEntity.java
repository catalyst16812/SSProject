package com.catalyst.funds.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class TeamsEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer teamId;
  
	private String teamName;
	
	private Long fundGoal;
	
	private String cycle;
	
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
 
}