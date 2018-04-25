package com.dakun.jianzhong.utils.mybatis;

import org.apache.ibatis.binding.MapperProxy;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * <p>User: wangjie
 * <p>Date: 4/5/2017
 */
public class MybatisUtils {

    private static final String MAPPER_INTERFACE_FIELD_NAME = "mapperInterface";

    private static final String MAPPER_PROXY_JDK_DYNAMIC_AOP_PROXY = "org.apache.ibatis.binding.MapperProxy";

    public static Class<?> getMapperInterface(Object mapperImpl) {
        if (Proxy.isProxyClass(mapperImpl.getClass())) {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(mapperImpl);
            if (invocationHandler.getClass().getName().equals(MAPPER_PROXY_JDK_DYNAMIC_AOP_PROXY)) {
                MapperProxy mapperProxy = (MapperProxy) invocationHandler;

                Field interfaceField =
                        ReflectionUtils.findField(mapperProxy.getClass(), MAPPER_INTERFACE_FIELD_NAME);
                interfaceField.setAccessible(true);
                return (Class) ReflectionUtils.getField(interfaceField, mapperProxy);
            }
        }
        return null;
    }
}
