package com.kh.totaljpaSample.repository;

import com.kh.totaljpaSample.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
