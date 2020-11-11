/**
 * 传入一个工厂对象，并使用该对象创建新实例.
 * 缺点：Integer没有无参构造函数，会抛出异常。
 * 建议使用显示工程并限制类型（例如：Supplier<Integer>）。
 *
 * https://lingcoder.gitee.io/onjava8/#/book/20-Generics?id=%e5%88%9b%e5%bb%ba%e7%b1%bb%e5%9e%8b%e7%9a%84%e5%ae%9e%e4%be%8b
 *
 * @author fuwb
 * @date 2020-06-03
 */
package com.javacore.generic.factory.sample01;