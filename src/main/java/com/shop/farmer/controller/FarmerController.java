package com.shop.farmer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.farmer.dto.Farmer;
import com.shop.farmer.service.FarmerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/farmers")
@RequiredArgsConstructor
public class FarmerController {

    private final FarmerService farmerService;

    // CREATE
    @PostMapping
    public ResponseEntity<Farmer> createFarmer(@RequestBody Farmer farmer) {
        Farmer created = farmerService.createFarmer(farmer);
        return ResponseEntity.ok(created);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Farmer>> getAllFarmers() {
        return ResponseEntity.ok(farmerService.getAllFarmers());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Farmer> getFarmerById(@PathVariable Long id) {
        return ResponseEntity.ok(farmerService.getFarmerById(id));
    }
    
    
    @GetMapping("/mobile/{mobile}")
    public ResponseEntity<Farmer> getFarmerByMobile(@PathVariable(required = false,name="mobile") String mobile) {
        return ResponseEntity.ok(farmerService.findByMobile(mobile));
    }
    
    @GetMapping("/village/{village}")
    public ResponseEntity<List<Farmer>> getFarmerByVillage(@PathVariable(required = false,name="village") String mobile) {
        return ResponseEntity.ok(farmerService.findByVillage(mobile));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Farmer> updateFarmer(
            @PathVariable Long id,
            @RequestBody Farmer farmer) {

        Farmer updated = farmerService.updateFarmer(id, farmer);
        return ResponseEntity.ok(updated);
    }

  

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFarmer(@PathVariable Long id) {
        farmerService.deleteFarmer(id);
        return ResponseEntity.ok("Farmer deleted successfully");
    }
}
