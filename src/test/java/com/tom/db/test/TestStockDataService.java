package com.tom.db.test;

import com.tom.db.entity.StockData;
import com.tom.db.service.IStockDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.tom.db.TestApplication.class)
@TestPropertySource(locations = "/test-application.properties")
@AutoConfigureTestDatabase(replace = NONE)
@Rollback(value = false)
public class TestStockDataService {

    @Autowired(required=true)
    @Qualifier("stockDataService")
    private IStockDataService service;

    @Test
    public void testCreate() {
        String prodId = "prod-1234";
        StockData entity = new StockData();
        entity.setRest(20);
        entity.setProductId(prodId);
        System.out.println(service.createEntity(entity));
    }



    @Test
    public void testDecr(){
        String prodId = "prod-1234";
        System.out.println(service.update(prodId));
    }

    @Test
    public void testUpdate(){
        String prodId = "prod-1234";
        int rest = 3;
        service.update(prodId, rest);
    }

}
