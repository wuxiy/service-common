package com.dakun.jianzhong.utils.mybatis;

import com.google.common.base.CaseFormat;

import java.beans.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    public abstract void setId(ID id);

    public abstract ID getId();

    @Override
    public String toString() {
        return "BaseEntity{}";
    }

    public static void printProperties(Class<?> clazz, String prefix) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        List<String> ignores = Stream.of("class").collect(toList());// 排除的属性

        Arrays.stream(propertyDescriptors)
                .map(FeatureDescriptor::getName)
                .filter(name -> ignores.stream().noneMatch(s -> s.equals(name)))
                .forEach(name ->
                        System.out.println(prefix + CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name) + ","));
    }
}
