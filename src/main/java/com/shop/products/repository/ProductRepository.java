package com.shop.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.products.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
	List<ProductEntity> findAll();

	ProductEntity save(ProductEntity p);

}
