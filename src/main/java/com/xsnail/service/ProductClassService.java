package com.xsnail.service;

import com.xsnail.bean.ProductClass;
import com.xsnail.dao.ProductClassRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * 产品分类service
 * Created by 刘海鹏 on 2017/9/20
 */
@Service
public class ProductClassService {

    private static final Logger logger = LoggerFactory.getLogger(ProductClassService.class);

    @Autowired
    private ProductClassRepository productClassRepository;

    public ProductClass getById(String id) {
        return productClassRepository.findById(id).get();
    }

    public List<ProductClass> getAll() {
        return productClassRepository.findAll();
    }

    public ProductClass saveOrUpdate(ProductClass productClass) {
        return productClassRepository.save(productClass);
    }

    public void deleteById(String id) {
        productClassRepository.deleteById(id);
    }

}