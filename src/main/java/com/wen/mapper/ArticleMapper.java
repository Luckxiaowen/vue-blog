package com.wen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wen.domain.entity.Article;


/**
 * (Article)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-02 20:45:56
 */
public interface ArticleMapper extends BaseMapper<Article> {
    public Page<Article> selectArticleVo(Page<Article> page);

}

