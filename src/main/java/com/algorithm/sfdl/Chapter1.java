package com.algorithm.sfdl;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/20 0020 12:11
 */
public class Chapter1 {

    /**
     * 1.2-2　假设我们正比较插入排序与归并排序在相同机器上的实现。对规模为n的输入，插入排序运行8n2步，而归并排序运行64nlgn步。问对哪些n值，插入排序优于归并排序？
     *
     * 插入排序的性能优于合并排序也就是：插入排序所用的步数少：
     *
     * 所以有：8n2 ≤ 64nlgn    ⇒      n < 8lgn 需要解一下这个超越方程，
     * 编个程序很容易得到： 2 ≤ n ≤ 43
     */
    public static void practice1_2_2() {
        for (int i = 2; i < 50; i++) {
            float n = Float.valueOf(String.valueOf(i));
            if (n < 8 * (Math.log(n) / Math.log(2.0))) {
                System.out.println(n);
            } else {
                break;
            }
        }
    }

    /**
     * 1.2-3　n的最小值为何值时，运行时间为100n2的一个算法在相同机器上快于运行时间为2n的另一个算法？
     *
     * 原理同上题，可列出如下不等式：100n2 ≤ 2n 解这个不等式(代数法)
     * 可求出最小的整数 n=15
     */
    public static void practice1_2_3() {
        for (int i = 1; i < 50; i++) {
            float n = Float.valueOf(String.valueOf(i));
            if (100 * n * n > Math.pow(2.0, n)) {
                System.out.println(i);
            } else {
                break;
            }
        }
    }

}
