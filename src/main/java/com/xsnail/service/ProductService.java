package com.xsnail.service;

import com.xsnail.bean.Product;
import com.xsnail.dao.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/***
 * 产品service
 * Created by 刘海鹏 on 2017/9/20
 */
@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public Product getById(String id) {
        Product product = productRepository.getOne(id);
        return product;
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}