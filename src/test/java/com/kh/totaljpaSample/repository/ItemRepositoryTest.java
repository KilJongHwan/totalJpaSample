package com.kh.totaljpaSample.repository;

import com.kh.totaljpaSample.constant.ItemSellStatus;
import com.kh.totaljpaSample.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    public void createItemList(){
        for (int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setItemName("테스트 상품"+ i);
            item.setPrice(10000);
            item.setItemDetail("테스트 상품에 대한 상세 설명"+ i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            Item saveItem = itemRepository.save(item);
            System.out.println(saveItem);
        }
    }
    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNameTest(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemName("테스트 상품5");
        for (Item item : itemList){
            System.out.println(item);
        }
    }

    @Test
    @DisplayName("상품 테스트")
    public void createItemTest(){
        Item item = new Item();
        item.setItemName("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품에 대한 상세 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        Item saveItem = itemRepository.save(item);
        System.out.println(saveItem);
    }
    @Test
    @DisplayName("상품명 or 상품 상세 설명")
    public void findByItemNameOrItemDetail(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByItemNameOrItemDetail("테스트 상품1",
                "테스트 상품에 대한 상세 설명5");
        for (Item item : itemList){
            System.out.println(item);
        }
    }
}