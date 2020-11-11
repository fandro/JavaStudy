package com.javacore.generic.base;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.*;

import static java.lang.annotation.ElementType.*;

/**
 * 类型变量 TypeVariable .
 *
 * @author fuwb
 * @date 2020-05-25
 */
public class TypeVariableTest<T extends @TypeVariableTest.Custom Number & Serializable> {

    public T field;

    public static void main(String[] args) throws NoSuchFieldException {

        final Field field = TypeVariableTest.class.getField("field");

        final Type genericType = field.getGenericType();
        if (genericType instanceof TypeVariable) {
            TypeVariable fieldType = (TypeVariable)genericType;
            // 获取泛型T的名称
            System.out.println(fieldType.getName());

            // 获取T的上界类型，<T extends Number> 中的Number
            final Type[] bounds = fieldType.getBounds();
            for (Type bound : bounds) {
                System.out.println(bound.toString());
            }

            // 获取上界的AnnotatedType类型
            final AnnotatedType[] annotatedBounds = fieldType.getAnnotatedBounds();
            for (AnnotatedType annotatedBound : annotatedBounds) {
                System.out.println(annotatedBound.toString());
                System.out.println(annotatedBounds[0].getAnnotations()[0].annotationType());
            }

            //GenericDeclaration接口继承AnnotatedElement接口，所以可以很方便的获取声明类型的注解信息, 本例中的是 @Custom
            final GenericDeclaration declaration = fieldType.getGenericDeclaration();
            System.out.println(declaration.toString());
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(value = {TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER, TYPE_USE})
    @interface Custom {

    }

}
