package com.Order.Warehouse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int warehouseId;
    private String warehouseName;
    private String location;
    private int stock;
    private double latitude;
    private double longitude;
    private double distance;
}
