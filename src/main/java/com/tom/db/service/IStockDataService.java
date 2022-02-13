package com.tom.db.service;

import com.tom.db.entity.StockData;
import com.tom.db.service.tool.IEntityService;

public interface IStockDataService extends IEntityService<StockData,Long> {

    public int update(String productId);

    public boolean update(String productId, int rest);
}
