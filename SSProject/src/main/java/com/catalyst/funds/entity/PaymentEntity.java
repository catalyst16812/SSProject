package com.catalyst.funds.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PaymentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int paymentId;
	private int userId;
	private String date;
	private int teamId;
	private String txnId;
	private long amount;
	
	  
	
}
