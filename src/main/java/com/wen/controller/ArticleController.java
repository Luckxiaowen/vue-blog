package com.wen.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wen.annoticon.SysLog;
import com.wen.domain.ResponseResult;
import com.wen.domain.entity.Article;
import com.wen.domain.entity.Category;
import com.wen.domain.entity.TagList;
import com.wen.service.ArticleService;
import com.wen.service.CategoryService;
import com.wen.service.TagListService;
import com.wen.service.TagService;
import com.wen.utils.BeanCopyUtils;
import com.wen.domain.vo.ArticleListVo;
import com.wen.domain.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagListService tagListService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResponseResult list(@RequestParam(required = false) Integer categoryId){
        List<ArticleListVo> articleVoList = articleService.articleVoList(categoryId);
        return ResponseResult.okResult(articleVoList);
    }

    @SysLog(businessName = "查看文章")
    @GetMapping("/{id}")
    public ResponseResult articleInfo(@PathVariable Integer id){
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getId,id);
        queryWrapper.eq(Article::getIsRelease,1);
        Article article = articleService.getOne(queryWrapper);
        ArticleVo articleVo = BeanCopyUtils.copyBean(article, ArticleVo.class);

        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Category::getId,article.getCategoryId());
        String categoryName = categoryService.getOne(wrapper).getCategoryName();
        articleVo.setCategoryName(categoryName);
        return ResponseResult.okResult(articleVo);
    }











}
