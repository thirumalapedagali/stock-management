package com.shop.products.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.products.dto.Product;
import com.shop.products.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

	ProductService productService;
   
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return null;
    }

    // ---------------------------
    // POST (create product)
    // ---------------------------
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
       
        return productService.addProduct(product);
    }

    // ---------------------------
    // PUT (update entire product)
    // ---------------------------
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        
        return productService.updateProduct(id, updatedProduct);
    }

    // ---------------------------
    // PATCH (partial update)
    // ---------------------------
    @PatchMapping("/{id}")
    public Product updateProductPartially(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
       
        return null;
    }

    // ---------------------------
    // DELETE (delete product)
    // ---------------------------
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
    	productService.delete(id);
        return "Product deleted successfully.";
    }
}