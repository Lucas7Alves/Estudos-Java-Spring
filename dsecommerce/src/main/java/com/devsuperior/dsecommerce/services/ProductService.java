package com.devsuperior.dsecommerce.services;

import java.sql.Savepoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devsuperior.dsecommerce.dto.ProductDTO;
import com.devsuperior.dsecommerce.entities.Product;
import com.devsuperior.dsecommerce.repositories.ProductRepository;
import com.devsuperior.dsecommerce.services.exception.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)	
	public ProductDTO findById(Long id) {
		return new ProductDTO( productRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Product not found")));
	}
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pageable) {
		Page<Product> result = productRepository.findAll(pageable);
		return result.map(x -> new ProductDTO(x));
	}
	
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		copyDtoToEntity(dto, entity);
		return new ProductDTO(productRepository.save(entity));
	}
	
	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		Product entity = productRepository.getReferenceById(id);
		copyDtoToEntity(dto, entity);
		return new ProductDTO(productRepository.save(entity));
	}

	@Transactional
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
	
	private void copyDtoToEntity(ProductDTO dto, Product entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImgUrl(dto.getImgUrl());
	}
	
}
