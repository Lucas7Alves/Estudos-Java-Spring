package com.estudos.aula;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.estudos.aula.entities.Order;
import com.estudos.aula.services.OrderService;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner {

	@Autowired
	OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter code: ");
		int code = sc.nextInt();
		
		System.out.println("Enter basic: ");
		double basic = sc.nextDouble();
		
		System.out.println("Enter discount: ");
		double discount = sc.nextDouble();
		
		Order o1 = new Order(code, basic, discount);
		
		System.out.println("Code order: " + o1.getCode());
		System.out.printf("Total value: %.2f", orderService.total(o1));
	}

}
