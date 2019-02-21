package com.xsnail.service;

import com.xsnail.bean.Staff;
import com.xsnail.dao.StaffRepository;
import com.xsnail.utils.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 货品预报详情service
 * Created by 刘海鹏 on 2017/9/20
 */
@Service
public class StaffService {

    private static final Logger logger = LoggerFactory.getLogger(StaffService.class);

    @Autowired
    private StaffRepository staffRepository;

    public Staff login(String text, String password) throws Exception {
        String encrypted = MD5.encoder(password);
        Staff staff = staffRepository.findByNameAndPassword(text, encrypted);
        if (staff == null) {
            staff = staffRepository.findByMobileAndPassword(text, encrypted);
        }

        return staff;
    }

}