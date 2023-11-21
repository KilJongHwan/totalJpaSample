package com.kh.totaljpaSample.repository;

import com.kh.totaljpaSample.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// 기본적인 CRUD는 JpaRepository에 이미 정의 되어 있다, 페이징 처리도 포함 되어 있음.
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemName(String itemName);
    // OR 조건 처리
    List<Item> findByItemNameOrItemDetail(String itemName, String itemDetail);
    // LessThan 조건 처리 : price 변수 보다 작은 상품 데이터 조회하는 쿼리
    List<Item> findByPriceLessThan(Integer price);
    // OrderBy로 정렬
    List<Item> findAllByOrderByPriceDesc();
}
