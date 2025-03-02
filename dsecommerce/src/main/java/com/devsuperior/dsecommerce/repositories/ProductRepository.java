package com.devsuperior.dsecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
