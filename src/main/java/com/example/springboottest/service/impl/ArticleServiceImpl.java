package com.example.springboottest.service.impl;

import com.example.springboottest.config.ArticleSettings;
import com.example.springboottest.mapper.ArticleMapper;
import com.example.springboottest.po.Bean1;
import com.example.springboottest.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor//这个注解就是申明我要使用构造的方式进行注入,这个注解是lombo的
public class ArticleServiceImpl implements ArticleService   {




    private final ArticleMapper articleMapper;
    /*上面这个地方现在报错是因为mapper的类还没有放入容器中管理*/
    private final ArticleSettings articleSettings;


    /*public ArticleServiceImpl(ArticleMapper articleMapper  ){
        this.articleMapper=articleMapper;
    }*/
/*    当然上面这种构造方式的注入也是可以不用手写的，可以用注解*/
//    上面这个赋值是不改变的，所以要用final
/*    然后上面的赋值方式是多种的，框架的，java的，还有可以是推荐的构造方式赋值*/
    @Override
    public List<Bean1> queryTopArticle() {
        //获取配置类中的两个要求
        Integer topRead = articleSettings.getTop_read();
        Integer lowRead = articleSettings.getLow_read();
        //在业务处理层调用mapper层的数据处理方法
//        List<Bean1> sortByReadCount = articleMapper.toSortByReadCount(lowRead, topRead);
        return articleMapper.toSortByReadCount( lowRead, topRead);
    }
}
