package com.tom.db.test;

import com.tom.db.entity.UserData;
import com.tom.db.service.IUserDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.tom.db.TestApplication.class)
@TestPropertySource(locations = "/test-application.properties")
@AutoConfigureTestDatabase(replace = NONE)
@Rollback(value = false)
public class TestUserData {

    @Autowired(required=true)
    @Qualifier("userDataService")
    private IUserDataService service;

    @Test
    public void query(){
        long id = 1;
        System.out.println(service.getEntityById(id));
    }


    @Test
    public void testCreate() {
        String prodId = "prod-1234";
        UserData entity = new UserData();
        entity.setUserName("Benny");
        System.out.println(service.createEntity(entity));
    }

}
