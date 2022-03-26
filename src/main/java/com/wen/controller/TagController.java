package com.wen.controller;

import com.wen.domain.ResponseResult;
import com.wen.domain.entity.Tag;
import com.wen.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public ResponseResult list(){
        List<Tag> tagList = tagService.list();
        return ResponseResult.okResult(tagList);
    }
}
