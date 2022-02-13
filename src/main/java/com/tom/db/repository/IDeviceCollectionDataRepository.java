package com.tom.db.repository;

import com.tom.db.entity.DeviceCollectionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "deviceCollectionDataRepository")
public interface IDeviceCollectionDataRepository extends JpaRepository<DeviceCollectionData, Long> {

}
