package com.Order.Warehouse.Controller;
import com.Order.Warehouse.Entity.Order;
import com.Order.Warehouse.kafka.OrderProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderProducer.sendOrder(order);
        return new ResponseEntity<>("Order is getting processes", HttpStatus.ACCEPTED);
    }
}
