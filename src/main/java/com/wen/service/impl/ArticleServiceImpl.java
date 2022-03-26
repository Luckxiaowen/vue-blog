package com.wen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wen.domain.ResponseResult;
import com.wen.domain.entity.Article;
import com.wen.mapper.ArticleMapper;
import com.wen.mapper.TagMapper;
import com.wen.service.ArticleService;
import com.wen.utils.BeanCopyUtils;
import com.wen.utils.PageUtils;
import com.wen.domain.vo.ArticleListVo;
import com.wen.domain.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Article)表服务实现类
 *
 * @author makejava
 * @since 2022-03-02 20:45:57
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private TagMapper tagMapper;
    @Override
    public ResponseResult adminList(Integer pageNum, Integer pageSize) {
        Page<Article> page = new Page<>(pageNum,pageSize);
        Page<Article> articlePage = getBaseMapper().selectArticleVo(page);
        List<Article> articles = articlePage.getRecords();
        List<ArticleVo> articleVoList = BeanCopyUtils.copyBeanList(articles, ArticleVo.class);
        PageUtils<Article> pageUtils = new PageUtils((int) page.getTotal(),articleVoList);
        return ResponseResult.okResult(pageUtils);
    }

    @Override
    public List<ArticleListVo> articleVoList(Integer categoryId) {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getIsRelease,1);
        if (categoryId != null){
            wrapper.eq(Article::getCategoryId,categoryId);
        }
        List<Article> articleList = list(wrapper);
        List<ArticleListVo> articleListVo = BeanCopyUtils.copyBeanList(articleList, ArticleListVo.class);

        for (ArticleListVo listVo : articleListVo) {
            List<String> tags = tagMapper.selectTagByArticleId(listVo.getId());
            listVo.setTagName(tags);
        }

        return articleListVo;
    }


}

