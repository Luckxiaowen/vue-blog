package com.wen.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Tag)表实体类
 *
 * @author makejava
 * @since 2022-03-03 21:24:38
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tag")
public class Tag  {
    //标签id
    @TableId(type = IdType.AUTO)
    private Integer id;

    //标签名字
    private String tagName;
    //逻辑删除 0删除 1正常
    @TableLogic
    private Integer delFlag;



}

