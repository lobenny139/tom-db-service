package com.tom.db.service.provider;

import com.tom.redis.service.provider.GenericRedisService;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Component
@Service
public class DeviceCollectionDataRedisService extends GenericRedisService {

    private static Logger logger = LoggerFactory.getLogger(DeviceCollectionDataRedisService.class);

    @Autowired(required = true)
    @Qualifier(value = "redisTemplate9")
    private RedisTemplate<String, Object> redisTemplate;



}
