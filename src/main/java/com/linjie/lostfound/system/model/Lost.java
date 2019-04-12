package com.linjie.lostfound.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Lost {
    @Id @GeneratedValue
    private Long id; //主键
    private String title; //标题
    private String type; //类型
    private Date lostTime; //丢失时间   单词1单词2  ，lost + time  单词2首字母大写 = lostTime
    private String location; //丢失地点
    private boolean retrieve = false; //是否找回 ,false表示未被找回
    private String information; //详细信息
    private String contacts; //联系人
    private String phone; //电话
    private String image; //图片存放路径

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getLostTime() {
        return lostTime;
    }

    public void setLostTime(Date lostTime) {
        this.lostTime = lostTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRetrieve() {
        return retrieve;
    }

    public void setRetrieve(boolean retrieve) {
        this.retrieve = retrieve;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
