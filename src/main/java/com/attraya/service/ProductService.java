package com.attraya.service;

import com.attraya.entity.Product;
import com.attraya.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product getProductById(int id){
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("product not present with id: " + id));
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public List<Product> getProductsByCategory(String category){
        return repository.findByCategory(category);
    }

    // Sales Team: Update the stock of a product in (IS)
    public Product updateStock(int id, int stock){
        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found with id: " + id));
        existingProduct.setStock(stock);
        return repository.save(existingProduct);
    }

    // Warehouse: Receive new shipment
    public Product receiveNewShipment(int id, int qty){
        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found with id: " + id));
        existingProduct.setStock(existingProduct.getStock() + qty);
        return repository.save(existingProduct);
    }

}
