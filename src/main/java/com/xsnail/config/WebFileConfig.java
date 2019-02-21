package com.xsnail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/***
 * 配置web访问绝对路径的静态资源
 * Created by 刘海鹏 on 2019/2/21.
 */
@Configuration
public class WebFileConfig extends WebMvcConfigurationSupport {

    @Value("${file.path}")
    private String basePath;

    @Value("${file.accessPath}")
    private String apiPath;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(apiPath).addResourceLocations("file:" + basePath);
        super.addResourceHandlers(registry);
    }
}
