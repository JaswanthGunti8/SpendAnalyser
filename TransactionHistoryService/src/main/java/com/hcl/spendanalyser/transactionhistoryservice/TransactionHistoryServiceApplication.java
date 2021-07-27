package com.hcl.spendanalyser.transactionhistoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TransactionHistoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionHistoryServiceApplication.class, args);
	}

}
