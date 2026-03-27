package com.shop.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.inventory.entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {

	InventoryEntity save(InventoryEntity inv);

	@Query("SELECT i FROM InventoryEntity i JOIN FETCH i.product")
	List<InventoryEntity> findAllWithProduct();			

}
