package com.tom.db.beanServiceConfig;

import com.tom.db.service.IDeviceCollectionDataService;
import com.tom.db.service.provider.DeviceCollectionDataRedisService;
import com.tom.db.service.provider.DeviceCollectionDataService;
import com.tom.redis.service.IGenericRedisService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceAccessConfig {

    // ---------------------- 在這註冊你的資料表存取服務 -------------------

    @Bean(name="deviceCollectionDataService")
    public IDeviceCollectionDataService deviceCollectionDataService(){
        return new DeviceCollectionDataService();
    }

    // ---------------------- 在這註冊你的Redis存取服務 -------------------
    @Bean(name = "deviceCollectionDataRedisService" )
    public IGenericRedisService deviceCollectionDataRedisService() {
        return new DeviceCollectionDataRedisService();
    }

}
