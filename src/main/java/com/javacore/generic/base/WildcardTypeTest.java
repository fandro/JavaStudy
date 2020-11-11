package com.javacore.generic.base;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Map;

/**
 * 通配符类型。
 *
 * @author fuwb
 * @date 2020-05-25
 */
public class WildcardTypeTest{

    /**
     * ? extends Number, map的key必须继承Number，即key类型上界是Number，常做为生产者。
     * ? super String，map的value 必须是String的父类，即value的下界类型是String，常做为消费者。
     */
    public Map<? extends Number, ? super String> field;

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = WildcardTypeTest.class.getField("field");
        Type fieldType = field.getGenericType();

        // 参数化类型
        if (fieldType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType)fieldType;

            // 获取key的类型 ? extends Number
            Type keyType = type.getActualTypeArguments()[0];
            // 获取value类型 ? super String
            Type valueType = type.getActualTypeArguments()[1];


            if (keyType instanceof WildcardType) {
                WildcardType keyWildcardType = (WildcardType)keyType;
                final Type[] upperBounds = keyWildcardType.getUpperBounds();
                for (Type upperBound : upperBounds) {
                    // 输出上界类型 Number
                    System.out.println(upperBound.toString());
                }
                // 没有下界类型，返回为空
                final Type[] lowerBounds = keyWildcardType.getLowerBounds();
                for (Type lowerBound : lowerBounds) {
                    System.out.println(lowerBound.toString());
                }
            }

            if (valueType instanceof WildcardType) {
                WildcardType valueWildcardType = (WildcardType)valueType;

                // 没有上界类型，返回为空
                final Type[] upperBounds = valueWildcardType.getUpperBounds();
                for (Type upperBound : upperBounds) {
                    System.out.println(upperBound.toString());
                }

                final Type[] lowerBounds = valueWildcardType.getLowerBounds();
                for (Type lowerBound : lowerBounds) {
                    // 输出下界类型String
                    System.out.println(lowerBound.toString());
                }
            }
        }
    }


}
