package com.dakun.jianzhong.utils;

import com.dakun.jianzhong.utils.mybatis.DeleteLogicalMapper;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

import java.util.List;

/**
 * Created by wangh09 on Thu Jul 13 14:40:19 GMT+08:00 2017.
 */
public interface Mapper<T>
        extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T>,
        DeleteLogicalMapper<T> {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = ReplaceProvider.class, method = "dynamicSQL")
    int insertAll(List<T> recordList);
    @InsertProvider(type = ReplaceProvider.class, method = "dynamicSQL")
    int batchUpdate(List<T> recordList);
}
