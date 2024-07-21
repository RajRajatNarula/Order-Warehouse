package com.Order.Warehouse.Service;
import com.Order.Warehouse.Entity.Warehouse;
import com.Order.Warehouse.Repository.WarehouseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    @Transactional
    public Warehouse findNearestWarehouse(Double orderLatitude, Double orderLongitude,List<Integer> warehouseIds, int quantity) {
        Warehouse warehouse = warehouseRepository.findNearestWarehouse(orderLatitude,orderLongitude,warehouseIds,quantity);
        return warehouse;
    }

    @Transactional
    public void updateStock(Warehouse warehouse, int quantity) {
        warehouseRepository.updateWarehouse(warehouse.getStock()-quantity,warehouse.getWarehouseId());
    }

    public void insertWarehouse(Warehouse warehouse)
    {
        try
        {
            warehouseRepository.save(warehouse);
        }
        catch (Exception e)
        {
            log.info("Error occured while warehouse creation");
            log.info(e.getMessage());
        }
    }
}
