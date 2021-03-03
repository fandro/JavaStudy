package com.algorithm.$1_datastructure.recursion;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-11-18
 */
public class MyRecursion {

    private static String temp = "";

    public static void main(String[] args) {

        for (int i = 0; i < 10 ; i++) {
            System.out.println("recursion: "+i + ":" + fibonacciBaseOnRecursion(i));
            System.out.println("loop:      "+i + ":" + fibonacciBaseOnLoop(i));
        }
    }

    /**
     * 斐波那契数列 (Fibonacci sequence)
     * F(0)=0，F(1)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 2，n ∈ N*）
     * @param n
     * @return
     */
    private static int fibonacciBaseOnRecursion(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacciBaseOnRecursion(n -1) + fibonacciBaseOnRecursion(n -2);
    }

    /**
     * 斐波那契数列 (Fibonacci sequence)
     * F(0)=0，F(1)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 2，n ∈ N*）
     * @param n
     * @return
     */
    private static int fibonacciBaseOnLoop(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int sum = 0;
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }

        return sum;
    }



    private static int sum(int n){
        if (n == 1) {
            return 1;
        }
        if ("".equals(temp)) {
            temp = n +" + ";
        }
        String tempCur = temp;
        temp = temp + "(" + (n-1) +" + ";
        System.out.println(tempCur + " sum("+(n-1)+") ");
        return n + sum(n-1);
    }

}

