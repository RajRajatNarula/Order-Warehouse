package com.Order.Warehouse.kafka;
import com.Order.Warehouse.Entity.Order;
import com.Order.Warehouse.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "orders", groupId = "order-group")
    public Order consume(Order order) {
       order = orderService.processOrder(order);
       return  order;
    }
}
