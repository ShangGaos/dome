package com.example.springboottest.controller;

import com.example.springboottest.Vo.ArticleVo;
import com.example.springboottest.po.Bean1;
import com.example.springboottest.service.ArticleService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor//lombock中的构造器注入注解
@Controller
public class ArticleCountroller {


    private final ArticleService articleService;

    @GetMapping(value = {"/","article/hot"})//这里是指定两个路径都是可以访问方法的
    public String showHotArticle(Model model   ){

        List<Bean1> bean1s = articleService.queryTopArticle();
        //上面是查询的结果数据，但是返回给前端不能是全部的，这里 要vo,也就是要格式化一下数据
        //转化vo,使用的是一个工具类,.hutool,报错是要加mevan的工具类没有加，所以没有这个类
        List<ArticleVo> s = BeanUtil.checkUnsupportedType(/*articleService,fff ArticleVo.class*/);
        List<ArticleVo> s = BeanUtil.checkUnsupportedType(/*articleService, 456ArticleVo.class*/);

        //添加数据返回
        model.addAttribute("articleList",s);

        return "/blog/articleview";
    }

}
