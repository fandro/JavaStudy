package com.javacore.lambda;

import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * 1. 函数接口，接口中只有一个方法
 * 2. 参数类型推断机制
 *
 * @author feako
 * @since 2018/4/27
 */
public class LambdaTest {

    /**
     * lambda表达式书写
     */
    @Test
    public void baseInfoTest() {

        // 1.1 原来写法
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("enhen!");
            }
        };

        // 1.2 lambda新写法,无参函数简写
        Runnable runnable2 = () -> System.out.println("enhen!");

        // 2.1 原来写法
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        // 2.2 lambda写法
        ActionListener listener2 = event -> System.out.println("button clicked");


    }
}
