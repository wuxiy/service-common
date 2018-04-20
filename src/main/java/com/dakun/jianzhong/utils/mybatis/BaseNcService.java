package com.dakun.jianzhong.utils.mybatis;

import com.dakun.jianzhong.utils.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
public class BaseNcService<E extends BaseEntity<ID>, ID extends Serializable>{

    Logger logger = LoggerFactory.getLogger(getClass());

    protected Mapper<E> baseMapper;

    @Autowired
    public void setBaseMapper(Mapper<E> baseMapper) {
        this.baseMapper = baseMapper;
    }

    protected final Class<E> entityClass;

    public BaseNcService() {
        this.entityClass = ReflectUtils.findParameterizedType(getClass(), 0);
    }

    List<E> list() {
        return baseMapper.selectAll();
    }

}
