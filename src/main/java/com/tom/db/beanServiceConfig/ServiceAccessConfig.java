package com.tom.db.beanServiceConfig;

import com.tom.cache.service.provider.DeviceCollectionDataRedisService;
import com.tom.db.service.IDeviceCollectionDataService;
import com.tom.db.service.IStockDataService;
import com.tom.db.service.provider.DeviceCollectionDataDBAndCacheService;
import com.tom.db.service.provider.DeviceCollectionDataService;
import com.tom.db.service.provider.StockDataService;
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

    @Bean(name="deviceCollectionDataDBAndCacheService")
    public IDeviceCollectionDataService deviceCollectionDataDBAndCacheService(){
        return new DeviceCollectionDataDBAndCacheService();
    }

    @Bean(name="stockDataService")
    public IStockDataService stockDataService(){
        return new StockDataService();
    }

    // ---------------------- 在這註冊你的Redis存取服務 -------------------
    @Bean(name = "deviceCollectionDataRedisService" )
    public IGenericRedisService deviceCollectionDataRedisService() {
        return new DeviceCollectionDataRedisService();
    }


}
