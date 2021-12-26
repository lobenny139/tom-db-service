package com.tom.db.repository;

import com.tom.db.entity.DeviceCollectionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;

@Repository
public interface IDeviceCollectionDataRepository extends JpaRepository<DeviceCollectionData, Long> {

//    @Query(nativeQuery=true, value="SELECT * FROM device_collection_data entity WHERE entity.create_date = ?1")
//    public Iterable<DeviceCollectionData> findByCreateDate(String createDate);
//
//    @Query(nativeQuery=false, value="SELECT entity FROM DeviceCollectionData entity WHERE entity.deviceId = ?1 and entity.dataKey = ?2")
//    public Iterable<DeviceCollectionData> findByDeviceIdAndDataKey(String deviceId, String dataKey);
//
//    @Query(nativeQuery=false, value="SELECT entity FROM DeviceCollectionData entity WHERE entity.deviceId = ?1 and entity.createDate = ?2")
//    public Iterable<DeviceCollectionData> findByDeviceIdAndCreateDate(String deviceId, Date createDate);

}
