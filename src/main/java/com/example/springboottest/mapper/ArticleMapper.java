package com.example.springboottest.mapper;


import com.example.springboottest.po.Bean1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*接口*/
@Mapper
public class ArticleMapper {

    @Select("""

select id,articleId,content
from article
where red_count >= {lowRed}
order by red_count desc
limit {toRead}
/*整个部分做到是查询，根据条件查询，然后结果要排序以多少条返回*/ 

""")
    /*然后是结果映射*/
    /*注意这里的作用与印象中提到的驼峰命名*/
    @Result(id=true/*,vlaue={
            @Result(id = true,column = "id"),
            @Result(column = "user_id")
    }*/)


    public List<Bean1> toSortByReadCount(Integer lowRead,Integer topRead){

        Bean1 bean1 = new Bean1();
        return (List<Bean1>) bean1;
    }


    /*public void toSortByReadCount() {
    }*/
}
