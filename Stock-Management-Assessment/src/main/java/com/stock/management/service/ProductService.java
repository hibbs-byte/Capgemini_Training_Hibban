package com.stock.management.service;

import com.stock.management.entity.Product;
import com.stock.management.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;

    public Product add(Product p) {
        return repo.save(p);
    }

    public Product update(Integer id, Product p) {
        Product ex = repo.findById(id).orElseThrow();
        ex.setName(p.getName());
        ex.setCategory(p.getCategory());
        ex.setCompany(p.getCompany());
        ex.setQuantity(p.getQuantity());
        ex.setPrice(p.getPrice());
        return repo.save(ex);
    }

    public List<Product> searchByName(String name) {
        return repo.findByNameContaining(name);
    }

    public List<Product> searchByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Product> searchByCompany(String company) {
        return repo.findByCompany(company);
    }
}