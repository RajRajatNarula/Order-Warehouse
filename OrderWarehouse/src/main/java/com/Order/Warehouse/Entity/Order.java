package com.Order.Warehouse.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_table")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int orderId;
    private String product;
    private int quantity;

    private  String status="New";
    private double orderLatitude;
    private double orderLongitude;
}
