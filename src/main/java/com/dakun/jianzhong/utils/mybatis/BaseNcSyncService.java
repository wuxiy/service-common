package com.dakun.jianzhong.utils.mybatis;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
public class BaseNcSyncService<S extends BaseEntity<SID>, SID extends Serializable, T extends BaseEntity<TID>, TID extends Serializable>
        extends BaseNcService<S, SID> {

    protected BaseSyncService<T, TID> crmService;

    protected String syncName;

    protected final Class<T> targetClass;

    public BaseNcSyncService() {
        this.targetClass = ReflectUtils.findParameterizedType(getClass(), 2);
    }

    @Autowired
    public void setCrmService(@Qualifier BaseSyncService<T, TID> baseSyncService) {
        this.crmService = baseSyncService;
    }

    public void ncToCrm() {
        try {
            logger.info("[{}]开始同步", getSyncName());
            List<S> ncItems = getNcDocs();
            List<T> docs = Lists.newArrayList();

            for (S ncDoc : ncItems) {
                T crmDoc = converNcDocToCrmDoc(ncDoc);
                processNcDocToCrmDoc(ncDoc, crmDoc);
                docs.add(crmDoc);
            }

            int i = crmService.saveDocs(docs);
            logger.info("[{}]同步，待插入的记录数：[{}]，插入的记录数：[{}]",
                    new Object[]{getSyncName(), docs.size(), i});
            logger.info("[{}]同步完成", getSyncName());
        } catch (Exception e) {
            logger.error("[{}]失败", getSyncName(), e);
        }
    }

    protected List<S> getNcDocs() {
        return list();
    }

    /**
     * 通过 ncdoc 生成 crmDoc
     *
     * @param ncDoc
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected T converNcDocToCrmDoc(S ncDoc) throws IllegalAccessException, InstantiationException {
        T crmDoc = targetClass.newInstance();
        BeanUtils.copyProperties(ncDoc, crmDoc);

        return crmDoc;
    }

    /**
     * 默认什么都不做，子类可覆盖自定义同步字段
     *
     * @param ncDoc
     * @param crmDoc
     */
    protected void processNcDocToCrmDoc(S ncDoc, T crmDoc) {

    }

    public String getSyncName() {
        return syncName;
    }

    public void setSyncName(String syncName) {
        this.syncName = syncName;
    }
}
