package com.wen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wen.domain.entity.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据userID获取对应权限
     * @param id  user ID
     * @return
     */
    List<String> getPath(Integer id);
}
