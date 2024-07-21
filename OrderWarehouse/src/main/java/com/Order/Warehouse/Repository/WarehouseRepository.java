package com.Order.Warehouse.Repository;
import com.Order.Warehouse.Entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse,String>
{

    @Query(value = "SELECT warehouse_id, warehouse_name, location, stock, latitude, " +
            "longitude,(6371 * acos(cos(radians(:orderLatitude)) * cos(radians(latitude)) * " +
            "cos(radians(longitude) - radians(:orderLongitude)) + sin(radians(:orderLatitude)) * " +
            "sin(radians(latitude)))) AS distance" +
            " from warehouse where stock >= :quantity and warehouse_id in :warehouseIds ORDER BY distance LIMIT 1"
            ,nativeQuery = true)
    Warehouse findNearestWarehouse(@Param("orderLatitude") double orderLatitude,@Param("orderLongitude") double orderLongitude,@Param("warehouseIds") List<Integer> warehouseIds,@Param("quantity") int quantity);

    @Transactional
    @Modifying
    @Query(value = "Update warehouse set stock = :quantity where warehouse_id = :warehouseId", nativeQuery = true)
    void updateWarehouse(@Param("quantity") int quantity,@Param("warehouseId") int warehouseId);
}
