package com.example.springjdbctransactions.repository;

import com.example.springjdbctransactions.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Product> productRowMapper = (rs, rowNum) ->
            new Product(rs.getLong("id"), rs.getString("name"), rs.getDouble("price"));

    public void save(Product product) {
        jdbcTemplate.update("INSERT INTO products (name, price) VALUES (?, ?)",
                product.getName(), product.getPrice());
    }

    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM products", productRowMapper);
    }
}
