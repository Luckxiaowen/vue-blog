package com.wen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wen.domain.ResponseResult;
import com.wen.domain.entity.Article;
import com.wen.domain.vo.ArticleListVo;

import java.util.List;


/**
 * (Article)表服务接口
 *
 * @author makejava
 * @since 2022-03-02 20:45:26
 */
public interface ArticleService extends IService<Article> {
    ResponseResult adminList(Integer pageNum, Integer pageSize);

    List<ArticleListVo> articleVoList(Integer categoryId);
}

