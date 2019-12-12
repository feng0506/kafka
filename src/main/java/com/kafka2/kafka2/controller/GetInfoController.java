package com.kafka2.kafka2.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kafka2.kafka2.dao.GetInfoDao;
import com.kafka2.kafka2.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class GetInfoController {

    @Autowired
    private KafkaTemplate template;

    @Autowired
    private GetInfoDao getInfoDao;

    @Autowired
    private UserInfo userInfo;

  //  private static final String topic = "real_data";

    private static final String topic = "test3";

    /**
     * 消息接受者
     */
    @KafkaListener(id="" , topics =  topic , groupId = "group.demo" )
  //  @KafkaListener(id="realdata" , topics =  topic , groupId ="yehengda")
    public void listener(String input ){

        JSONObject jsonObject = JSONObject.parseObject(input);

        System.out.println("name:"+jsonObject.getString("name")+",phone:"+jsonObject.getString("phone"));
        userInfo.setName(jsonObject.getString("name"));
        userInfo.setPhone(jsonObject.getString("phone"));
        getInfoDao.insert(userInfo);
    }
}
