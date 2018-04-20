package com.dakun.jianzhong.utils.mybatis;

import com.dakun.jianzhong.utils.AbstractService;
import tk.mybatis.mapper.entity.Condition;

import java.io.Serializable;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
public class BaseSyncService<E extends BaseEntity<ID>, ID extends Serializable>
        extends AbstractService<E> {

    public int saveDocs(List<E> docs) {
        deleteAll();
        save(docs);
        return docs.size();
    }
    public int deleteAll() {
    Condition example = newCondition();
    example.createCriteria().andCondition("1=1");
    return deleteByCondition(example);
}
}
