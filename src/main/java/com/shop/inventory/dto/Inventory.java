package com.shop.inventory.dto;

import com.shop.products.entity.ProductEntity;

public record Inventory(Long id,String batchNo,Integer quantity,ProductEntity product) {
	

}
