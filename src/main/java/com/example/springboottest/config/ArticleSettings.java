package com.example.springboottest.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 这个类的作用是读取配置文件中的初始化显示数量app-base.yml中的配置数据
 */
@Data
@ConfigurationProperties(prefix = "article")//这里的报错是因为没有启用这个配置类自动类，在主类中使用EnableCon..进行启动
public class ArticleSettings {

    private Integer low_read;
    private Integer top_read;
}
