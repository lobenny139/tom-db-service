package com.tom.db.repository;

import com.tom.db.entity.StockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository(value = "stockDataRepository")
public interface IStockDataRepository extends JpaRepository<StockData, Long> {

    @Transactional
    @Modifying
    @Query( nativeQuery = true,
            value = "update stock_data set rest = rest-1   WHERE product_id = ?1")
    public void updateRest(String productId);

    @Query( nativeQuery=true,
            value="SELECT * FROM stock_data entity WHERE entity.product_id = ?1")
    public StockData findByProductId(String productId);





}
