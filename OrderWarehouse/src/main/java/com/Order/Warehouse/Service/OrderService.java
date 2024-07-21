package com.Order.Warehouse.Service;
import com.Order.Warehouse.Entity.Order;
import com.Order.Warehouse.Entity.Warehouse;
import com.Order.Warehouse.Repository.OrderRepository;
import com.Order.Warehouse.Repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Order processOrder(Order order) {
        log.info("ProcessOrder with orderId : "+order.getOrderId());
        try
        {
            List<Integer> warehouseIds = productRepository.findProductWarehouses(order.getProduct());
            Warehouse warehouse = warehouseService.findNearestWarehouse(order.getOrderLatitude(),order.getOrderLongitude(),warehouseIds,order.getQuantity());

            if (warehouse != null) {
                warehouseService.updateStock(warehouse, order.getQuantity());
                order.setStatus("COMPLETED");
            } else {
                order.setStatus("Out of Stock");
            }
            orderRepository.save(order);

        }
        catch (Exception e)
        {
            System.out.println("Exception : "+e);
        }
        return  order;
    }
}
