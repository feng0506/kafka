package com.kafka2.kafka2;

import com.kafka2.kafka2.dao.GetInfoDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Kafka2ApplicationTests {

    @Test
    void contextLoads() {

    }
    @Autowired
    private GetInfoDao getInfoDao;
    @Test
    public void justTest(){
    }

}
