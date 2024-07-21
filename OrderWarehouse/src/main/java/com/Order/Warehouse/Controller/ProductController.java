package com.Order.Warehouse.Controller;

import com.Order.Warehouse.Entity.Order;
import com.Order.Warehouse.Entity.Product;
import com.Order.Warehouse.Entity.Warehouse;
import com.Order.Warehouse.Service.ProductService;
import com.Order.Warehouse.Service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController
{

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productService.insertProduct(product);
        return new ResponseEntity<>("Product Inserted", HttpStatus.CREATED);
    }
}