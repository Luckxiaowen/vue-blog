package com.wen.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("role")
public class Role {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String roleKey;

    private String name;

    private Date createTime;

    @TableLogic
    private Integer delFlag;



}
