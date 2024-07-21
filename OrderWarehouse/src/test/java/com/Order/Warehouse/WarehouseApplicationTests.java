package com.Order.Warehouse;
import com.Order.Warehouse.Controller.OrderController;
import com.Order.Warehouse.Entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class WarehouseApplicationTests {
	@Autowired
	OrderController orderController;

	@Test
	void contextLoads() {
	}

	@Test
	void OrderControllerTest()
	{
		log.info("Entered OrderControlleTest");
		Order order = new Order();
		order.setProduct("ProductB");
		order.setQuantity(10);
		order.setStatus("New");
		order.setOrderLatitude(40.7128);
		order.setOrderLongitude(-74.0060);
		orderController.createOrder(order);

	}

}
