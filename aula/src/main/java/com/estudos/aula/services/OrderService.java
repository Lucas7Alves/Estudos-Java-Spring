package com.estudos.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.aula.entities.Order;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;
	
	public double total(Order order) {
		return order.getBasic() - (order.getBasic() * (order.getDiscount()/100)) 
				+ shippingService.shipment(order);
	}
}
