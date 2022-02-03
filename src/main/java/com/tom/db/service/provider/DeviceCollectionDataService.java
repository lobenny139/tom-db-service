package com.tom.db.service.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tom.db.entity.DeviceCollectionData;
import com.tom.db.repository.IDeviceCollectionDataRepository;
import com.tom.db.service.IDeviceCollectionDataService;
import com.tom.db.service.tool.EntityService;
import com.tom.redis.service.IGenericRedisService;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
@Setter
@Component
@Service
public class DeviceCollectionDataService extends EntityService<DeviceCollectionData, Long> implements IDeviceCollectionDataService {

    private static Logger logger = LoggerFactory.getLogger(DeviceCollectionDataService.class);

    @Autowired(required = true)
    @Qualifier(value = "deviceCollectionDataRepository")
    protected IDeviceCollectionDataRepository repository;

    @Autowired(required = true)
    @Qualifier(value = "deviceCollectionDataRedisService")
    protected IGenericRedisService redisService;

    @Override
    public DeviceCollectionData createEntity(DeviceCollectionData entity) {
        try {
            entity.setUpdateDate(null);
            if (entity.getCreateDate() == null) {
                entity.setCreateDate(new Date());
            }
            DeviceCollectionData record = super.saveEntity(entity);
            // todo async redis set
            getRedisService().set(record.getId().toString(), new ObjectMapper().writeValueAsString(record), 120);
            return record;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public DeviceCollectionData updateEntity(Long id, DeviceCollectionData entity) {
        try {
            DeviceCollectionData record = super.getEntityById(id);
            if (entity.getDeviceId() != null) {
                record.setDeviceId(entity.getDeviceId());
            }
            if (entity.getDataKey() != null) {
                record.setDataKey(entity.getDataKey());
            }
            if (entity.getDataValue() != null) {
                record.setDataValue(entity.getDataValue());
            }
            record.setUpdateDate(new Date());
            // todo async redis set
            getRedisService().set(record.getId().toString(), new ObjectMapper().writeValueAsString( record ), 120);
            return updateEntity(id, record);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public DeviceCollectionData getEntityById(Long id)  {
        try {
            Object json = getRedisService().get(id.toString());
            if (json != null) {
                return new ObjectMapper().readValue(json.toString(), DeviceCollectionData.class);
            } else {
                DeviceCollectionData record = super.getEntityById(id);
                getRedisService().set(record.getId().toString(), new ObjectMapper().writeValueAsString( record ), 120);
                return record;
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteEntity(Long id) {
        try {
            getRedisService().del(id.toString());
            return super.deleteEntity(id);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
