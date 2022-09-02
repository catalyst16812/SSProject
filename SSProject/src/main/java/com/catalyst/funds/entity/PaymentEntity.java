package com.catalyst.funds.entity;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

public class PaymentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int paymentId;
	private String date;
	private String txnId;
	private long amount;
	
	@ManyToMany
	@JoinTable(name="UserPayments", joinColumns = @JoinColumn(name ="payment_id"), inverseJoinColumns = @JoinColumn(name="team_id"))
	private Set<TeamsEntity> teamsEntities;
	@ManyToMany
	@JoinTable(name="UserPayments", joinColumns = @JoinColumn(name ="payment_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
	private Set<UserEntity> userEntities;
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Set<TeamsEntity> getTeamsEntities() {
		return teamsEntities;
	}
	public void setTeamsEntities(Set<TeamsEntity> teamsEntities) {
		this.teamsEntities = teamsEntities;
	}
	public Set<UserEntity> getUserEntities() {
		return userEntities;
	}
	public void setUserEntities(Set<UserEntity> userEntities) {
		this.userEntities = userEntities;
	}
	
	  
	
}
