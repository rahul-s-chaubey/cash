package com.idbiintech.cash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EnableJpaRepositories(
//        basePackages = {"com.idbiintech.cash.Controller","com.idbiintech.cash.DTO","com.idbiintech.cash.Entity","com.idbiintech.cash.Repository","com.idbiintech.cash.Service","com.idbiintech.cash.ServiceImpl"}
//        )
public class CashApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashApplication.class, args);
		System.out.println("hello");
	}
	
	

}
