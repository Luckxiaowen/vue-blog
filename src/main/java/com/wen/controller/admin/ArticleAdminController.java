package com.wen.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wen.domain.ResponseResult;
import com.wen.domain.entity.Article;
import com.wen.domain.entity.TagList;
import com.wen.domain.vo.ArticleVo;
import com.wen.enums.AppHttpCodeEnum;
import com.wen.exception.SystemException;
import com.wen.service.ArticleService;
import com.wen.service.TagListService;
import com.wen.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class ArticleAdminController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagListService tagListService;

    @GetMapping("/article/list")
    public ResponseResult articleList(@RequestParam(defaultValue = "1") Integer pageNum
            , @RequestParam(defaultValue = "10") Integer pageSize){
        return articleService.adminList(pageNum,pageSize);
    }

    @PostMapping("/state/{state}/{id}")
    public ResponseResult changeState(@PathVariable("state") Integer status,@PathVariable("id") Integer id){
        Article article = new Article();
        try {
            article.setId(id);
            article.setIsRelease(status);
            articleService.updateById(article);
            return ResponseResult.okResult();
        }catch (Exception e){
            return ResponseResult.errorResult(400,e.getMessage());
        }
    }

    @DeleteMapping("/article/{id}")
    public ResponseResult delArticle(@PathVariable("id") Integer id){
        boolean res = articleService.removeById(id);
        if (res){
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(400,"删除失败!");
    }

    @GetMapping("/article/{id}")
    public ResponseResult getArticleById(@PathVariable("id") Integer id){
        Article article = articleService.getById(id);
        ArticleVo articleVo = BeanCopyUtils.copyBean(article, ArticleVo.class);
        LambdaQueryWrapper<TagList> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TagList::getArticleId,id);
        List<Integer> tagIdList = new ArrayList<>();
        for (TagList tagList : tagListService.list(queryWrapper)) {
            tagIdList.add(tagList.getTagId());
        }
        articleVo.setTagIdList(tagIdList);
        return ResponseResult.okResult(articleVo);
    }

    @PostMapping("/article")
    public ResponseResult add(@RequestBody Article article){
        boolean res = articleService.save(article);;
        if (res){
            int id = article.getId();
            List<TagList> tagLists = new ArrayList<>();
            for (Integer tag : article.getTag()) {
                tagLists.add(new TagList(id,tag.intValue()));
            }
            tagListService.saveBatch(tagLists,5);
            return ResponseResult.okResult(200,"添加成功!");
        }else {
            throw new SystemException(AppHttpCodeEnum.SYSTEM_ERROR);
        }
    }

    @PutMapping("/article")
    public ResponseResult update(@RequestBody Article article){
        boolean res = articleService.updateById(article);
        if (res){
            int id = article.getId();
            LambdaQueryWrapper<TagList> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TagList::getArticleId,id);
            tagListService.remove(queryWrapper);
            List<TagList> tagLists = new ArrayList<>();
            for (Integer tag : article.getTag()) {
                tagLists.add(new TagList(id,tag.intValue()));
            }
            tagListService.saveBatch(tagLists,5);
            return ResponseResult.okResult(200,"修改成功!");
        }
        throw new SystemException(AppHttpCodeEnum.SYSTEM_ERROR);
    }
}
