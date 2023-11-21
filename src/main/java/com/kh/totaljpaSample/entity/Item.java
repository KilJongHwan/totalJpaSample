package com.kh.totaljpaSample.entity;

import com.kh.totaljpaSample.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Item {
    private Long id;    // 상품 코드
    private String itemNum; // 상품명
    private int price; // 가격
    private int stockNumber; // 재고 수량
    private int itemDetail; // 상품 상세 설명
    private ItemSellStatus itemSellStatus;
    private LocalDateTime regTime; // 등록 시간
    private LocalDateTime updateTime; // 수정 시간
}
