package com.xsnail.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/***
 * 员工bean
 * Created by 刘海鹏 on 2019/2/19 15:00.
 */
@Entity
@Table(name = "t_staff")
public class Staff {

    /** 员工ID */
    @Id
    @GenericGenerator(name = "idGenerator" ,strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    /** 姓名 */
    @Column(name = "name" , length =  1)
    private String name;

    /** 密码 */
    @Column(name = "password")
    private String password;

    /** 手机号 */
    @Column(name = "mobile")
    private String mobile;

    /** 头像 */
    @Column(name = "head_img")
    private String headImg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
