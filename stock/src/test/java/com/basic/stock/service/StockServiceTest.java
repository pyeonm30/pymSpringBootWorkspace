package com.basic.stock.service;

import com.basic.stock.entity.Stock;
import com.basic.stock.repository.StockRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockServiceTest {

    @Autowired
    private StockService service;
    @Autowired
    private StockRepository repository;

    @BeforeEach
    public void insert(){
        // 상품 아이디가 1 이고 수량이 100 인 재고 한개 생성
        Stock stock = new Stock(1L, 100L);
        repository.saveAndFlush(stock);

    }
    @Test
    public void decreseTest(){
        service.decreaseStock(1L,1L); // 상품id 1 인 상품의 수량을 1씩 감소
        Stock stock = repository.findById(1L).orElseThrow();
        System.out.println("stock = " + stock);
        System.out.println("count = " + stock.getQuantity());
        Assertions.assertThat(stock.getQuantity()).isEqualTo(99);

    }

}