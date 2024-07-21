package com.Order.Warehouse.Repository;

import com.Order.Warehouse.Entity.Product;
import com.Order.Warehouse.Entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String>
{
    @Query(value = "Select warehouse_id from product where product_name = :productName",nativeQuery = true)
    List<Integer> findProductWarehouses(@Param("productName") String productName);

}
