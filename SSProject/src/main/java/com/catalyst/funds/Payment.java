package com.catalyst.funds;

public class Payment {
	
	private int paymentId;
	private String date;
	private String txnId;
	private long amount;
	private String userName;
	private String teamId;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", date=" + date + ", txnId=" + txnId + ", amount=" + amount
				+ ", userName=" + userName + ", teamId=" + teamId + "]";
	}
	

	
}
