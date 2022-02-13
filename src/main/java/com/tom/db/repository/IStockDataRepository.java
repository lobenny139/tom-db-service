package com.tom.db.repository;

import com.tom.db.entity.StockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "stockDataRepository")
public interface IStockDataRepository extends JpaRepository<StockData, Long> {

    @Modifying
    @Query( nativeQuery = true,
            value = "update stock_data set rest = rest-1   WHERE product_id = ?1")
    public void updateStockData(String productId);

    @Modifying
    @Query( nativeQuery = true,
            value = "update stock_data set rest = ?2   WHERE product_id = ?1")
    public void updateStockData(String productId, int rest);


    @Query( nativeQuery=true,
            value="SELECT * FROM stock_data entity WHERE entity.product_id = ?1")
    public StockData findByProductId(String productId);







}
