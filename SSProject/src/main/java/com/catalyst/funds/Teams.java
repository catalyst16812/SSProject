package com.catalyst.funds;

import java.util.List;

public class Teams {

	private int teamId;
	private String teamName;
	private long fundGoal;
	private String cycle;
	private List<User> users ;
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public long getFundGoal() {
		return fundGoal;
	}
	public void setFundGoal(long fundGoal) {
		this.fundGoal = fundGoal;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", teamName=" + teamName + ", fundGoal=" + fundGoal + ", cycle=" + cycle
				+ ", users=" + users + "]";
	}
	
	

	
	
}
