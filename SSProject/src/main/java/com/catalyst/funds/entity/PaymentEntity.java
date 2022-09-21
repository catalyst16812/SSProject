package com.catalyst.funds.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PaymentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int paymentId;
	private String date;
	private String txnId;
	private long amount;
	
	//@ManyToMany
//	@JoinTable(name="UserPayments", joinColumns = @JoinColumn(name ="payment_id"), inverseJoinColumns = @JoinColumn(name="team_id"))
	
	@ManyToOne
	@JoinColumn(name="team_id")
    private TeamsEntity teamsEntitiy;
	
	@ManyToOne
	@JoinColumn(name="user_id")
//	@JoinTable(name="UserPayments", joinColumns = @JoinColumn(name ="payment_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
	private UserEntity userEntity;
	
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
	public TeamsEntity getTeamsEntitiy() {
		return teamsEntitiy;
	}
	public void setTeamsEntitiy(TeamsEntity teamsEntitiy) {
		this.teamsEntitiy = teamsEntitiy;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	
	
	  
	
}
