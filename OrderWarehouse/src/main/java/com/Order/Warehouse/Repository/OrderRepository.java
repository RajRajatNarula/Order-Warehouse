package com.Order.Warehouse.Repository;

import com.Order.Warehouse.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,String>
{

}
