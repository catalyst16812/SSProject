package com.catalyst.funds;

public class Teams {

	private int teamId;
	private String teamName;
	private long fundGoal;
	private String cycle;
	public int getTeamId() {
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
	public long getFundGoal() {
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
	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", teamName=" + teamName + ", fundGoal=" + fundGoal + ", cycle=" + cycle
				+ "]";
	}
	
}
