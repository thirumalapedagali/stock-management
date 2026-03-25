package com.shop.products.dto;

public record Product(
		Long id,
		String name,
		String brand,
		Double price,
		String category,
		String unit) {

}
