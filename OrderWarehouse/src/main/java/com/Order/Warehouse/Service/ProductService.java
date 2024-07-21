package com.Order.Warehouse.Service;

import com.Order.Warehouse.Entity.Product;
import com.Order.Warehouse.Repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class ProductService
{

    @Autowired
    ProductRepository productRepository;
    public void insertProduct(Product product)
    {
        try
        {
            productRepository.save(product);
        }
        catch (Exception e)
        {
            log.info("Error occured while product insertion");
            log.info(e.getMessage());
        }

    }
}
