package com.dakun.jianzhong.utils.mybatis;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * <p>User: wangjie
 * <p>Date: 8/14/2017
 */
public interface DeleteLogicalMapper<T> {

    @UpdateProvider(type = DeleteLogicalProvider.class, method = "dynamicSQL")
    @Options(useCache = false, useGeneratedKeys = false)
    int deleteLogicalByExample(Object condition);

    @UpdateProvider(type = DeleteLogicalProvider.class, method = "dynamicSQL")
    @Options(useCache = false, useGeneratedKeys = false)
    int deleteLogicalByPrimaryKey(Object key);

    @UpdateProvider(type = DeleteLogicalProvider.class, method = "dynamicSQL")
    @Options(useCache = false, useGeneratedKeys = false)
    int deleteLogicalByIds(String ids);
}
