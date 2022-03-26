package com.wen.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("menu")
public class Menu {
    @TableId(type = IdType.AUTO )
    private Integer id;

    private String menuName;

    private String path;

    private Integer delFlag;
}
