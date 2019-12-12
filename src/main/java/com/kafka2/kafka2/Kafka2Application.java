package com.kafka2.kafka2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kafka2.kafka2.dao.GetInfoDao;
import com.kafka2.kafka2.entity.UserInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@SpringBootApplication
@MapperScan(basePackages = {"com.kafka2.kafka2.dao"})
public class Kafka2Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Kafka2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Kafka2Application.class, args);
    }

//    @Autowired
//    private KafkaTemplate template;
//
//    @Autowired
//    private GetInfoDao getInfoDao;
//
//    private static final String topic = "test3";
//
//    /**
//     * 消息生产者
//     * @param input
//     * @return
//     */
//    @GetMapping("send/{input}")
//    public String sendToKafka(@PathVariable  String input){
//
//        this.template.send(topic , input);
//
//        return "send success!!  " + input;
//    }
//
//    /**
//     * 消息接受者
//     */
//    @KafkaListener(id="" , topics =  topic , groupId = "group.demo" )
//    public void listener(String input ){
//
//        JSONObject jsonObject = JSONObject.parseObject(input);
//
//        System.out.println("name:"+jsonObject.getString("name")+",phone:"+jsonObject.getString("phone"));
//
//      //  UserInfo userInfo = new UserInfo();
//      //  userInfo.setName(input);
//     //   getInfoDao.insertUser(userInfo);
//     //   LOGGER.info("message input value:{}",input);
//    }
}
