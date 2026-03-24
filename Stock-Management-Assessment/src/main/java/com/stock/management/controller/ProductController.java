package com.stock.management.controller;

import com.stock.management.entity.Product;
import com.stock.management.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public Product add(@RequestBody Product p) {
        return service.add(p);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Integer id, @RequestBody Product p) {
        return service.update(id, p);
    }

    @GetMapping("/name")
    public List<Product> name(@RequestParam String name) {
        return service.searchByName(name);
    }
}