package com.shop.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.inventory.dto.Inventory;
import com.shop.inventory.entity.InventoryEntity;
import com.shop.inventory.mapper.InventoryMapper;
import com.shop.inventory.repository.InventoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    
    private InventoryMapper inventoryMapper;

    // Get all inventory records
    public List<Inventory> findAllWithProduct() {
    	
    	 List<InventoryEntity> all = inventoryRepository.findAllWithProduct();
    	 
    	 return all.stream().map(m->inventoryMapper.toDto(m)).toList();
    	 
    }

    // Get inventory by ID
    public Inventory getById(Long id) {
         InventoryEntity orElseThrow = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found with ID: " + id));
        return inventoryMapper.toDto(orElseThrow);
    }

    // Save or update inventory
    public Inventory save(Inventory inventory) {
        InventoryEntity save = inventoryRepository.save(inventoryMapper.toEntity(inventory));
        return inventoryMapper.toDto(save);
    }

    // Delete inventory by ID
    public void delete(Long id) {
        if (!inventoryRepository.existsById(id)) {
        	
        }
    }

	
}

