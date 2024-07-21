package com.Order.Warehouse.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int productId;
    private String productName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warehouseId", referencedColumnName = "warehouseId")
    private Warehouse warehouse;
}
