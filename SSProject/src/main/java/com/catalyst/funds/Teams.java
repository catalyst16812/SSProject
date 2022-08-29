package com.catalyst.funds;

public class Teams {

	private int teamId;
	private String teamName;
	private long fundGoal;
	private String cycle;
	private String username;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", teamName=" + teamName + ", fundGoal=" + fundGoal + ", cycle=" + cycle
				+ ", username=" + username + "]";
	}

	
	
}
