package com.javacore.generic.base;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 参数化类型 ParameterizedType.
 *
 * @author fuwb
 * @since 2020-05-23
 */
public class ParameterizedTypeTest {

    public Map<String, Integer> mapField;

    public Map.Entry<String, Integer> entry;


    public static void main(String[] args) throws NoSuchFieldException {
        // 通过反射获取Field
        Field mapField = ParameterizedTypeTest.class.getField("mapField");


        Field entryField = ParameterizedTypeTest.class.getField("entry");

        printParameterizedType(mapField);
        printParameterizedType(entryField);
    }

    private static void printParameterizedType(Field field) {
        // 获取field的Type信息
        Type fieldType = field.getGenericType();

        if (fieldType instanceof ParameterizedType) {
            // 获取泛型参数
            ParameterizedType parameterizedType = (ParameterizedType) fieldType;
            for (Type actualType : parameterizedType.getActualTypeArguments()) {
                System.out.println(actualType.getTypeName());
            }

            // 获取原类型(java.util.Map)
            Type rawType = parameterizedType.getRawType();
            System.out.println(rawType);

            // 获取ownerType顶层类型,如果没有顶层类型则返回null. 例如 Map.Entry
            Type ownerType = parameterizedType.getOwnerType();
            System.out.println(ownerType);

        }
    }
}
