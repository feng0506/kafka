package com.kafka2.kafka2.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kafka2.kafka2.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component("getInfoDao")
public interface GetInfoDao extends BaseMapper<UserInfo> {
    Integer insertUser(UserInfo userInfo);
}
