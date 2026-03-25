package com.shop.products.entity;

import java.util.List;

import com.shop.inventory.entity.InventoryEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String brand;
	private String category;
	private String unit;
	private Double price;
	@OneToMany(mappedBy = "product")
	private List<InventoryEntity> inventory;

}
