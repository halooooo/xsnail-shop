package com.xsnail.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/***
 * 产品分类bean
 * Created by 刘海鹏 on 2019/2/19 15:00.
 */
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" })
@Table(name = "t_product_class")
public class ProductClass {

    @Id
    @GenericGenerator(name = "idGenerator" ,strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "name" , length =  1)
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "remark")
    private String remark;

    @OneToMany(cascade={CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="prd_class_id")
    @JsonIgnore
    List<Product> products;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
