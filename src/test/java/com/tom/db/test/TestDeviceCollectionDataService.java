package com.tom.db.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
//    @Qualifier("deviceCollectionDataService")
    @Qualifier("deviceCollectionDataDBAndCacheService")
    private IDeviceCollectionDataService service;

    @Test
    public void query(){
        long id = 215;
        System.out.println(service.getEntityById(id));
    }

    @Test
    public void queryByNativeSQL(){
        String sql = "select * from device_collection_data where data_key='CO'";
        System.out.println(service.getEntitiesBySQL(sql));
    }

    @Test
    public void queryByNativeSQLNoWrap(){
        String sql = "select * from device_collection_data where data_key='CO'";
        System.out.println(service.getBySQLNoWrap(sql));
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

    @Test
    public void testConvert2Json() throws JsonProcessingException {
        Date now = new Date();
        String deviceId = "device-2345678901";
        DeviceCollectionData entity = new DeviceCollectionData();
        long id = 123;

        entity.setCreateDate(now);
        entity.setDeviceId(deviceId);
        entity.setDataKey("CO");
        entity.setDataValue("1.0");
//        System.out.println(entity.toString());
//        System.out.println(new ObjectMapper().writeValueAsString(entity));
        String json = new ObjectMapper().writeValueAsString(entity);
        DeviceCollectionData entity2 = new ObjectMapper().readValue(json, DeviceCollectionData.class);

        System.out.println(entity2.getDataKey());
    }

}
