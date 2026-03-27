package com.shop.inventory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.inventory.dto.Inventory;
import com.shop.inventory.service.InventoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@AllArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    // 1. Get all inventory records
    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.findAllWithProduct();
    }

    // 2. Get inventory by id
    @GetMapping("/{id}")
    public Inventory getById(@PathVariable Long id) {
        return inventoryService.getById(id);
    }

    // 3. Save a single inventory recordOO
    @PostMapping
    public Inventory saveInventory(@RequestBody Inventory inventory) {
        return inventoryService.save(inventory);
    }
    
    @PutMapping
    public Inventory updateInventory(@RequestBody Inventory inventory) {
        return inventoryService.save(inventory);
    }

    // 5. Delete inventory record
    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable Long id) {
        inventoryService.delete(id);
    }
}