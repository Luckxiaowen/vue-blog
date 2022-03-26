package com.wen.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVo {
    private Integer id;

    //文章标题
    private String title;

    //文章内容
    private String content;


    //文章分类
    private String categoryName;


    private Integer categoryId;

    //文章封面URL
    private String articleCoverUrl;

    //文章观看次数
    private Integer watchNumber;

    //发布时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    //文章简介
    private String introduction;

    //是否发布
    private Integer isRelease;

    List<Integer> tagIdList;

}
