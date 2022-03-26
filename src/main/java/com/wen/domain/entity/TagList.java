package com.wen.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (TagList)表实体类
 *
 * @author makejava
 * @since 2022-03-04 11:08:57
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tag_list")
public class TagList  {


    //文章id
    private Integer articleId;
    //标签id
    private Integer tagId;



}

