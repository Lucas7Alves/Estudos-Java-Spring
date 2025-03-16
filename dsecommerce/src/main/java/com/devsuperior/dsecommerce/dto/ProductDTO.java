package com.devsuperior.dsecommerce.dto;

import com.devsuperior.dsecommerce.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 80, message = "Deve estar entre 3 a 80 caracteres")
	private String name;
	
	@NotBlank
	@Size(min = 3, message = "Deve ter mais de 10 caracteres")
	private String description;
	
	@Positive
	private Double price;
	private String imgUrl;
	
	public ProductDTO() {
	}
	
	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();	
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	
}
