package com.attraya.resource;

import com.attraya.entity.Product;
import com.attraya.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @QueryMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @QueryMapping
    public List<Product> getProductsByCategory(@Argument String category){
        return productService.getProductsByCategory(category);
    }
}
