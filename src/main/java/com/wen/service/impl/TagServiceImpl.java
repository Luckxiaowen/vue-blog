package com.wen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wen.domain.entity.Tag;
import com.wen.mapper.TagMapper;
import com.wen.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * (Tag)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 21:24:38
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}

