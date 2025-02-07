package com.devsuperior.dsecommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPK {

	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order = new Order();

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product = new Product();

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
