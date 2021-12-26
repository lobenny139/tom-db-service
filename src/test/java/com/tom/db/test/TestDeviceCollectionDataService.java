package com.tom.db.test;


import com.tom.db.entity.DeviceCollectionData;
import com.tom.db.service.IDeviceCollectionDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.tom.db.TestApplication.class)
@TestPropertySource(locations = "/test-application.properties")
@AutoConfigureTestDatabase(replace = NONE)
@Rollback(value = false)
public class TestDeviceCollectionDataService {

    @Autowired(required=true)
    @Qualifier("deviceCollectionDataService")
    private IDeviceCollectionDataService service;

    @Test
    public void query(){
        long id = 160;
        System.out.println(service.getEntityById(id));
    }

    @Test
    public void create(){
        Date now = new Date();
        String deviceId = "device-2345678901";
        DeviceCollectionData entity = new DeviceCollectionData();
        entity.setCreateDate(now);
        entity.setDeviceId(deviceId);
        entity.setDataKey("CO");
        entity.setDataValue("1.0");
        System.out.println(service.createEntity(entity));

        entity = new DeviceCollectionData();
        entity.setCreateDate(now);
        entity.setDeviceId(deviceId);
        entity.setDataKey("PM25");
        entity.setDataValue("2.0");
        System.out.println(service.createEntity(entity));
//
        entity = new DeviceCollectionData();
        entity.setCreateDate(now);
        entity.setDeviceId(deviceId);
        entity.setDataKey("NO");
        entity.setDataValue("3.0");
        System.out.println(service.createEntity(entity));

        entity = new DeviceCollectionData();
        entity.setCreateDate(now);
        entity.setDeviceId(deviceId);
        entity.setDataKey("CO2");
        entity.setDataValue("4.0");
        System.out.println(service.createEntity(entity));

        entity = new DeviceCollectionData();
        entity.setCreateDate(now);
        entity.setDeviceId(deviceId);
        entity.setDataKey("NO2");
        entity.setDataValue("5.0");
        System.out.println(service.createEntity(entity));

        entity = new DeviceCollectionData();
        entity.setCreateDate(now);
        entity.setDeviceId(deviceId);
        entity.setDataKey("O3");
        entity.setDataValue("6.0");
        System.out.println(service.createEntity(entity));

        entity = new DeviceCollectionData();
        entity.setCreateDate(now);
        entity.setDeviceId(deviceId);
        entity.setDataKey("PM10");
        entity.setDataValue("7.0");
        System.out.println(service.createEntity(entity));
    }

}
