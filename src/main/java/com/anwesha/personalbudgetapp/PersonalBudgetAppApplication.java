package com.anwesha.personalbudgetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.anwesha"})
public class PersonalBudgetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalBudgetAppApplication.class, args);
	}

}

