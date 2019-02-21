package com.xsnail.dao;

import com.xsnail.bean.ProductClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/***
 * Created by 刘海鹏 on 2019/2/19
 */
@Repository
public interface ProductClassRepository extends JpaRepository<ProductClass, String>, JpaSpecificationExecutor<ProductClass> {
}
