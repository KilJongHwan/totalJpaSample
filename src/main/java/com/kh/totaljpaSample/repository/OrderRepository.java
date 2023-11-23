package com.kh.totaljpaSample.repository;

import com.kh.totaljpaSample.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
