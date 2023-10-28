package com.example.springboottest.po;

import lombok.Data;
//书的表
@Data
public class Bean {
    private Integer id;
    private Integer userId;
    private String title;
    private String create_time;
    private String update_time;

}
