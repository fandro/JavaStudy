package com.javacore.generic.base;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 泛型数组类型.
 *
 * @author fuwb
 * @since 2020-05-25
 */
public class GenericArrayTypeTest {

    public List<String>[] field;
    public Map.Entry<String, Integer>[] entryField;

    public static void main(String[] args) throws NoSuchFieldException {
        //通过反射获取Field
        Field field = GenericArrayTypeTest.class.getField("field");
        Field entryField = GenericArrayTypeTest.class.getField("entryField");

        printGenericArrayType(field);
        printGenericArrayType(entryField);
    }

    private static void printGenericArrayType(Field field) {
        // 获取field类型
        final Type genericType = field.getGenericType();
        if (genericType instanceof GenericArrayType) {
            // 获取数组中元素
            GenericArrayType genericArrayType = (GenericArrayType) genericType;
            Type genericComponentType = genericArrayType.getGenericComponentType();

            System.out.println(genericComponentType);

            // 如果是参数化类型ParameterizedType
            if (genericComponentType instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType)genericComponentType;

                System.out.println(parameterizedType.getActualTypeArguments());
                System.out.println(parameterizedType.getRawType());
                System.out.println(parameterizedType.getOwnerType());
            }
        }
    }
}
