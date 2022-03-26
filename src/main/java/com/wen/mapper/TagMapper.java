package com.wen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wen.domain.entity.Tag;

import java.util.List;

/**
 * (Tag)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-03 21:24:38
 */
public interface TagMapper extends BaseMapper<Tag> {

    List<String> selectTagByArticleId(Integer id);

}

