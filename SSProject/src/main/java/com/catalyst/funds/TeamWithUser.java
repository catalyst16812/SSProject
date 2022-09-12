package com.catalyst.funds;

public class TeamWithUser {

	private String username;
	private String teamname;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	@Override
	public String toString() {
		return "TeamWithUser [username=" + username + ", teamname=" + teamname + "]";
	}
	
}
