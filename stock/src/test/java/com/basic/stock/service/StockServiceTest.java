package com.basic.stock.service;

import com.basic.stock.entity.Stock;
import com.basic.stock.repository.StockRepository;
import org.junit.jupiter.api.BeforeEach;
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
        Stock stock = new Stock(1L, 100L);
    }

}