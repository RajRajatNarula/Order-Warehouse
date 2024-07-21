package com.Order.Warehouse.Controller;

import com.Order.Warehouse.Entity.Order;
import com.Order.Warehouse.Entity.Warehouse;
import com.Order.Warehouse.Service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController
{
    @Autowired
    WarehouseService warehouseService;

    @PostMapping
    public ResponseEntity<String> createWarehouse(@RequestBody Warehouse warehouse) {
        warehouseService.insertWarehouse(warehouse);
        return new ResponseEntity<>("Warehouse Created", HttpStatus.CREATED);
    }
}
