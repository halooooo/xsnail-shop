package com.xsnail.file;

import com.xsnail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/***
 * Created by 刘海鹏 on 2019/2/19.
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Value("${file.path}")
    private String basePath;

    @PostMapping(value = "/upload" , consumes = "multipart/form-data")
    public void upload(@RequestParam("file") MultipartFile file) throws Exception {
        File desFile = new File(basePath, file.getOriginalFilename());
        if(!desFile.getParentFile().exists()){
            desFile.mkdirs();
        }
        try {
            file.transferTo(desFile);
        } catch (Exception e) {
            throw new Exception();
        }
    }

}
