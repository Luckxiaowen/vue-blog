package com.wen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wen.domain.entity.Category;
import com.wen.mapper.CategoryMapper;
import com.wen.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * (Category)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 21:19:01
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}

