package com.example.springboottest.service;

import com.example.springboottest.po.Bean1;

import java.util.List;

public interface ArticleService {

    /*这里是业务层的接口*/
    List<Bean1> queryTopArticle() ;


}
