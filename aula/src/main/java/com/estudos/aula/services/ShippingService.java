package com.estudos.aula.services;

import org.springframework.stereotype.Service;

import com.estudos.aula.entities.Order;

@Service
public class ShippingService {
	
	public double shipment(Order order) {
		double value = order.getBasic();
		
		if (value < 100.0) {
			return 20.0;
		} else if (value >= 100.0 && value <= 200.0) {
			return 12.0;
		} else {
			return 0.0;
		}
	}

}
