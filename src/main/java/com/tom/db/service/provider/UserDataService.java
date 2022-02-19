package com.tom.db.service.provider;

import com.tom.db.entity.UserData;
import com.tom.db.repository.IUserDataRepository;
import com.tom.db.service.IUserDataService;
import com.tom.db.service.tool.EntityService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Getter
@Setter
@Component
@Service
public class UserDataService extends EntityService<UserData, Long> implements IUserDataService {

    @Autowired(required = true)
    @Qualifier(value = "userDataRepository")
    protected IUserDataRepository repository;

}
