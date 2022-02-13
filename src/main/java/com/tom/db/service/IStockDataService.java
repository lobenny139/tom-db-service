package com.tom.db.service;

import com.tom.db.entity.StockData;
import com.tom.db.service.tool.IEntityService;

public interface IStockDataService extends IEntityService<StockData,Long> {

    public int desc(String productId);
}
