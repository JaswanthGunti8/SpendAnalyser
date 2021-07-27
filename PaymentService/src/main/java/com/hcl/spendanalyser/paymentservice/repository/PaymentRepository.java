package com.hcl.spendanalyser.paymentservice.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.hcl.spendanalyser.paymentservice.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment,ObjectId>{
	

}
