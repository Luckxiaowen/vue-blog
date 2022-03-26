package com.wen.domain.entity;

import java.util.Date;

import java.util.List;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Article)表实体类
 *
 * @author makejava
 * @since 2022-03-02 20:45:25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("article")
public class Article  {
    //文章id
    @TableId(type = IdType.AUTO)
    private Integer id;

    //文章标题
    private String title;

    //文章简介
    private String introduction;

    //文章内容
    private String content;

    //文章封面URL
    private String articleCoverUrl;

    //文章分类id
    private Integer categoryId;

    //是否发布  1发布 0草稿
    private Integer isRelease;

    //文章观看次数
    private Integer watchNumber;

    //发布时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "release_date",fill = FieldFill.INSERT)
    private Date releaseDate;

    //逻辑删除 0删除 1正常
    @TableLogic
    private Integer delFlag;

    @TableField(exist = false)
    private List<Integer> tag;

    @TableField(exist = false)
    private String categoryName;



}

