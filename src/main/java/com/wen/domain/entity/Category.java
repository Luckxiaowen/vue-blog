package com.wen.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Category)表实体类
 *
 * @author makejava
 * @since 2022-03-03 21:19:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("category")
public class Category  {
    //类别id
    @TableId(type = IdType.AUTO)
    private Integer id;

    //类别名称
    private String categoryName;
    //逻辑删除 0删除 1正常
    @TableLogic
    private Integer delFlag;



}

