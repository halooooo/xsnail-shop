package com.xsnail.controller;

import com.xsnail.bean.ProductClass;
import com.xsnail.service.ProductClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Created by 刘海鹏 on 2019/2/19.
 */
@RestController
@RequestMapping(value = "/productClass")
public class ProductClassController {

    @Autowired
    private ProductClassService productClassService;

    @GetMapping(value = "/{id}")
    public ProductClass getById(@PathVariable String id) {
        return productClassService.getById(id);
    }

    @GetMapping(value = "/all")
    public List<ProductClass> getById() {
        return productClassService.getAll();
    }

    @PostMapping()
    public ProductClass save(@RequestBody ProductClass productClass) {
        return productClassService.saveOrUpdate(productClass);
    }

    @PutMapping()
    public ProductClass update(@RequestBody ProductClass productClass) {
        return productClassService.saveOrUpdate(productClass);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        productClassService.deleteById(id);
    }
}
