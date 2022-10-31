package com.catalyst.funds;

import java.util.List;

public class TeamWithmultiUser {

	private List<String> username;
	private String teamname;
	public List<String> getUsername() {
		return username;
	}
	public void setUsername(List<String> username) {
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
