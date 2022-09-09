package com.catalyst.funds.repositry;

import org.springframework.data.repository.CrudRepository;

import com.catalyst.funds.entity.PaymentEntity;
import com.catalyst.funds.entity.TeamsEntity;

public interface PaymentRepositry extends CrudRepository<PaymentEntity, Integer> {
	
	PaymentEntity findByTxnId(String txnId);
}
