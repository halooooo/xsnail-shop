package com.xsnail.controller;

import com.xsnail.bean.Product;
import com.xsnail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * Created by 刘海鹏 on 2019/2/19.
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public Product getById(@PathVariable String id) {
        return productService.getById(id);
    }

    @PostMapping()
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping()
    public Product update(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        productService.deleteById(id);
    }
}
