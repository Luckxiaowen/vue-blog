package com.wen.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String nickName;

    //用户类型 0管理员 1普通用户
    private Integer type;

    @TableField(value = "register_date",fill = FieldFill.INSERT)
    private Date registerDate;

    //逻辑删除 0删除 1正常
    @TableLogic
    private Integer delFlag;
}
