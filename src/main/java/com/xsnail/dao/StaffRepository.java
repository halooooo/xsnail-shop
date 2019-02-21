package com.xsnail.dao;

import com.xsnail.bean.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/***
 * Created by 刘海鹏 on 2019/2/19
 */
@Repository
public interface StaffRepository extends JpaRepository<Staff, String>, JpaSpecificationExecutor<Staff> {

    Staff findByNameAndPassword(String name, String password);

    Staff findByMobileAndPassword(String mobile, String password);
}
