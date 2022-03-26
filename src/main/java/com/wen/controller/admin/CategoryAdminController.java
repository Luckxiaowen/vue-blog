package com.wen.controller.admin;

import com.wen.domain.ResponseResult;
import com.wen.domain.entity.Category;
import com.wen.enums.AppHttpCodeEnum;
import com.wen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class CategoryAdminController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category/add")
    public ResponseResult add(@RequestBody Category category){
        try {
            categoryService.save(category);
            return ResponseResult.okResult();
        }catch (Exception e){
            return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
        }
    }

    @DeleteMapping("/category/{id}")
    public ResponseResult del(@PathVariable Integer id){
        try {
            categoryService.removeById(id);
            return ResponseResult.okResult();
        }catch (Exception e){
            return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
        }

    }
}
