package com.kh.totaljpaSample.repository;

import com.kh.totaljpaSample.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
