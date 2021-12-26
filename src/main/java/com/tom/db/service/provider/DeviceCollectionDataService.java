package com.tom.db.service.provider;

import com.tom.db.entity.DeviceCollectionData;
import com.tom.db.repository.IDeviceCollectionDataRepository;
import com.tom.db.service.IDeviceCollectionDataService;
import com.tom.db.service.tool.EntityService;
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
    protected IDeviceCollectionDataRepository repository;

    @Override
    public DeviceCollectionData createEntity(DeviceCollectionData entity) {
        entity.setUpdateDate(null);
        if(entity.getCreateDate() == null){
            entity.setCreateDate(new Date());
        }
        return saveEntity(entity);
    }

}
