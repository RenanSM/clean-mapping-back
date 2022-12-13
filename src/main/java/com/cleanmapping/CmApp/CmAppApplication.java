package com.cleanmapping.CmApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages= {"com.cleanmapping.CmApp.Api.controller"})
public class CmAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmAppApplication.class, args);
	}
}
