package com.first.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user_info")
public class UserInfo extends DbCommon {

    private static final long serialVersionUID = -7989302333329249863L;

    @Column(name = "user_token",length = 100)
    private String userToken;

    @Column(name = "user_name",length = 50)
    private String userName;

    @Column(name = "email",length = 20)
    private String email;

    @Column(name = "password",length = 50)
    private String password;

    @Column(name = "status")
    private Integer status;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "head_img",length = 100)
    private String headImg;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "mobile_phone",length = 11)
    private String mobilePhone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
