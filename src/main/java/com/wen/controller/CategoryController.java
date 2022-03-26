package com.wen.controller;

import com.wen.domain.ResponseResult;
import com.wen.domain.entity.Category;
import com.wen.enums.AppHttpCodeEnum;
import com.wen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResponseResult list(){
        List<Category> categoryList = categoryService.list();
        return ResponseResult.okResult(categoryList);
    }


}
