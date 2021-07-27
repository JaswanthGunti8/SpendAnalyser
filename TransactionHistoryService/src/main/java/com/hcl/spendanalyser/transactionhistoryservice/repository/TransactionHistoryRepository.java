package com.hcl.spendanalyser.transactionhistoryservice.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionHistory;

@Repository
public interface TransactionHistoryRepository extends MongoRepository<TransactionHistory,ObjectId>{
	@Query("{ 'customerId' : ?0 }")
	List<TransactionHistory> findAllByCustomerId(String customerId);
	
	@Query("{'customerId' : ?2, $expr:{$and:[{$eq:[{$year:'$tranDate'}, ?0]}, {$eq:[{$month:'$tranDate'}, ?1]}]}}")
    List<TransactionHistory> findByTranDateMatches(int year,int month,String customerId);
}
