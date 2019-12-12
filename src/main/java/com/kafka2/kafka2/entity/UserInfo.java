package com.kafka2.kafka2.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component(value="userInfo")
@TableName("userInfo")
public class UserInfo implements Serializable  {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String password;
    private int sex;
    private String phone;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
