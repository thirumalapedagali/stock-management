package com.shop.products.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.products.dto.Product;
import com.shop.products.entity.ProductEntity;
import com.shop.products.mapper.ProductMapper;
import com.shop.products.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	
	ProductRepository productRepository;
	
	ProductMapper mapper;
	
	public List<Product> getAllProducts(){
		List<ProductEntity> all = productRepository.findAll();
		return all.stream().map(p->mapper.toDto(p)).toList();
	}
	
	public Product addProduct(Product p) {
		ProductEntity pe = mapper.toEntity(p);
		return mapper.toDto(productRepository.save(pe));
	}
	
	public Product updateProduct(Long id,Product p) {
		ProductEntity pe = productRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
		mapper.updateEntityFromDto(p,pe);
		return mapper.toDto(productRepository.save(pe));
	}
	
	public void delete(Long id) {
		productRepository.deleteById(id);
	}

}
