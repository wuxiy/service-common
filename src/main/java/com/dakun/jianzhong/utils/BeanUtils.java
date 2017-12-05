package com.dakun.jianzhong.utils;

import com.google.common.collect.Maps;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.*;

/**
 * <p>User: wangjie
 * <p>Date: 10/13/2017
 */
public class BeanUtils {

    private BeanUtils() {}

    public static Map<String, Object> beanProperties(Object bean) {

        return beanProperties(bean, Object.class);
    }

    public static Map<String, Object> beanProperties(Object bean, Class<?> stopClass) {

        try {

            Map<String, Object> properties = Maps.newHashMap();

            List<PropertyDescriptor> descriptors = Arrays.asList(Introspector.getBeanInfo(bean.getClass(), stopClass)
                    .getPropertyDescriptors());

            for (PropertyDescriptor descriptor : descriptors) {
                if (Objects.isNull(descriptor.getReadMethod())) {
                    continue;
                }

                Object value;
                value = getValue(bean, descriptor);
                properties.put(descriptor.getName(), value);
            }

            return properties;
        } catch (IntrospectionException e) {
            // and this, too
            return Collections.emptyMap();
        }
    }

    private static Object getValue(Object bean, PropertyDescriptor descriptor) {
        Object value;
        try {
             value = descriptor.getReadMethod().invoke(bean);
        } catch (Exception e) {
            // replace this with better error handling
            value = null;
        }
        return value;
    }
}
