package com.catalyst.funds.controller;

import com.catalyst.funds.Payment;
import com.catalyst.funds.entity.PaymentEntity;
import com.catalyst.funds.entity.TeamsEntity;
import com.catalyst.funds.entity.UserEntity;
import com.catalyst.funds.repositry.PaymentRepositry;
import com.catalyst.funds.repositry.TeamsRepositry;
import com.catalyst.funds.repositry.UserRepositry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentRepositry payVar;
    @Autowired
    private UserRepositry userVar;
    @Autowired
    private TeamsRepositry teamVar;

    @PostMapping (path="/payments")
	public String alt(@RequestBody Payment P) {
		System.out.println(P);
		PaymentEntity pay = new PaymentEntity();
		pay.setAmount(P.getAmount());
		pay.setDate(P.getDate());
		pay.setTxnId(P.getTxnId());
		
	
		TeamsEntity entity = teamVar.findByTeamName(P.getTeamId());
	
	    pay.setTeamsEntitiy(entity);
		
		
		UserEntity entity2 = userVar.findByUserName(P.getUserName());
		
	    pay.setUserEntity(entity2);
		
		payVar.save(pay);
		return P.toString();
		
	}
}
