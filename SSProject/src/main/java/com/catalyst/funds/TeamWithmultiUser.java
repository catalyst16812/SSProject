package com.catalyst.funds;

import java.util.List;

public class TeamWithmultiUser {

	private List<String> userName;
	private String teamName;
    public List<String> getUserName() {
        return userName;
    }
    public void setUserName(List<String> userName) {
        this.userName = userName;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    @Override
    public String toString() {
        return "TeamWithmultiUser [userName=" + userName + ", teamName=" + teamName + "]";
    }
	
	

}
	

