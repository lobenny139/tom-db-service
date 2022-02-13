package com.tom.db.service.provider;

import com.tom.db.entity.StockData;
import com.tom.db.repository.IStockDataRepository;
import com.tom.db.service.IStockDataService;
import com.tom.db.service.tool.EntityService;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Getter
@Setter
@Component
@Service
public class StockDataService extends EntityService<StockData, Long> implements IStockDataService {

    private static Logger logger = LoggerFactory.getLogger(StockDataService.class);

    @Autowired(required = true)
    @Qualifier(value = "stockDataRepository")
    protected IStockDataRepository repository;
//    protected JpaRepository<StockData, Long> repository;



    @Override
    @Transactional
    public int update(String productId){
        try {
            getRepository().updateStockData(productId);
            return getRepository().findByProductId(productId).getRest();
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public boolean update(String productId, int rest){
        try {
            getRepository().updateStockData(productId, rest);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
