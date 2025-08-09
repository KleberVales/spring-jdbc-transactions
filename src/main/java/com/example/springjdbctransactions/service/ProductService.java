package com.example.springjdbctransactions.service;

import com.example.springjdbctransactions.model.Product;
import com.example.springjdbctransactions.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void addProduct(String name, double price) {
        if (price < 0) {
            throw new RuntimeException("Preço inválido para o produto: " + name);
        }
        repository.save(new Product(null, name, price));
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
