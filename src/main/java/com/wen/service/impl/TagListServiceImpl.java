package com.wen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wen.domain.entity.TagList;
import com.wen.mapper.TagListMapper;
import com.wen.service.TagListService;
import org.springframework.stereotype.Service;

/**
 * (TagList)表服务实现类
 *
 * @author makejava
 * @since 2022-03-04 11:08:57
 */
@Service("tagListService")
public class TagListServiceImpl extends ServiceImpl<TagListMapper, TagList> implements TagListService {

}

