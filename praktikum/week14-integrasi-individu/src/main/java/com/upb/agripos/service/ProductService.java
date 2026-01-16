package com.upb.agripos.service;

import java.util.List;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;

public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void insert(Product product) throws Exception {
        validateProduct(product);
        productDAO.insert(product);
    }

    public Product findByCode(String code) throws Exception {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Product code cannot be empty");
        }
        return productDAO.findByCode(code);
    }

    public List<Product> getAll() throws Exception {
        return productDAO.findAll();
    }

    public void update(Product product) throws Exception {
        validateProduct(product);
        productDAO.update(product);
    }

    public void delete(String code) throws Exception {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Product code cannot be empty");
        }
        productDAO.delete(code);
    }

    private void validateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (product.getCode() == null || product.getCode().trim().isEmpty()) {
            throw new IllegalArgumentException("Product code cannot be empty");
        }
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (product.getPrice() <= 0) {
            throw new IllegalArgumentException("Product price must be greater than 0");
        }
        if (product.getStock() < 0) {
            throw new IllegalArgumentException("Product stock cannot be negative");
        }
    }
}

