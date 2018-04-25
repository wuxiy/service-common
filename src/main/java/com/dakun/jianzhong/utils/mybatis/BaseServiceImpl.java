package com.dakun.jianzhong.utils.mybatis;


import com.dakun.jianzhong.utils.Mapper;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
public class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable>{

    public final static int BATCH_SIZE = 1000;

    protected Mapper<E> baseMapper;

    protected SqlSession sqlSessionBatch;

    @Autowired
    public void setBaseMapper(Mapper<E> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Autowired
    @Qualifier("sqlSessionBatch")
    public void setSqlSession(SqlSession sqlSessionBatch) {
        this.sqlSessionBatch = sqlSessionBatch;
    }

    /**
     * 实体类型
     */
    protected final Class<E> entityClass;

    public BaseServiceImpl() {
        this.entityClass = ReflectUtils.findParameterizedType(getClass(), 0);
    }

    // 获取batch mapper
    public Mapper<E> getMapperBatch() {
        return (Mapper<E>) sqlSessionBatch.getMapper(MybatisUtils.getMapperInterface(baseMapper));
    }

    public E get(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    public Optional<E> getOpt(ID id) {
        return Optional.ofNullable(get(id));
    }

    public E get(E entity) {
        return baseMapper.selectOne(entity);
    }

    public Optional<E> getOpt(E entity) {
        return Optional.ofNullable(get(entity));
    }

    public List<E> list(E entity) {
        return baseMapper.select(entity);
    }

    public List<E> list() {
        return baseMapper.selectAll();
    }

    public List<E> listByExample(Object example) {
        return baseMapper.selectByCondition(example);
    }

    public int save(E entity) {
        return baseMapper.insert(entity);
    }

    public int saveSelective(E entity) {
        return baseMapper.insertSelective(entity);
    }

    public int saveList(List<E> entices) {
        if (entices.size() > 0) {
            return baseMapper.insertList(entices);
        }
        return 0;
    }

    public List<ID> saveBatch(List<E> entices) {
        List<ID> ids = Lists.newArrayList();
        int count = 0;

        Mapper<E> mapperBatch =
                (Mapper<E>) sqlSessionBatch.getMapper(MybatisUtils.getMapperInterface(baseMapper));
        for (E entity : entices) {
            mapperBatch.insert(entity);
            ids.add(entity.getId());
            count++;

            if (count % BATCH_SIZE == 0) {
                sqlSessionBatch.flushStatements();
                count = 0;
            }
        }

        sqlSessionBatch.flushStatements();
        return ids;
    }

    public int saveOrUpdateSelective(E entity) {

        if (entity == null) {
            return 0;
        }

        if (entity.getId() != null) {
            return updateSelective(entity);
        } else {
            return saveSelective(entity);
        }
    }

    public int update(E entity) {
        return baseMapper.updateByPrimaryKey(entity);
    }

    public int update(List<E> entices) {
        int count = 0;

        for (E entity : entices) {
            count += update(entity);
        }
        return count;
    }

    public int updateSelective(E entity) {
        return baseMapper.updateByPrimaryKeySelective(entity);
    }

    public int updateBatch(List<E> entices) {
        int count = 0;

        Mapper<E> mapperBatch =
                (Mapper<E>) sqlSessionBatch.getMapper(MybatisUtils.getMapperInterface(baseMapper));
        for (E entity : entices) {
            count += mapperBatch.updateByPrimaryKey(entity);
        }
        return count;
    }

    public int updateBatchSelective(List<E> entices) {
        int count = 0;

        Mapper<E> mapperBatch =
                (Mapper<E>) sqlSessionBatch.getMapper(MybatisUtils.getMapperInterface(baseMapper));
        for (E entity : entices) {
            count += mapperBatch.updateByPrimaryKeySelective(entity);
        }
        return count;
    }

    public int delete(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    public int delete(E entity) {
        return baseMapper.delete(entity);
    }

    public int delete(Example example) {
        return baseMapper.deleteByCondition(example);
    }

    protected E newEntity() {
        try {
            return entityClass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("can not instantiated entity : " + this.entityClass, e);
        }
    }

    protected Mapper<E> getBatchMapper() {
        return (Mapper<E>) sqlSessionBatch.getMapper(MybatisUtils.getMapperInterface(baseMapper));
    }

    protected Example newExample() {
        return new Example(this.entityClass);
    }
}
