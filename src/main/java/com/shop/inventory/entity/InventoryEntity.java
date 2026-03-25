package com.shop.inventory.entity;

import com.shop.products.entity.ProductEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="inventory")
public class InventoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String batchNo;
	private Integer quantity;
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity product;

}
