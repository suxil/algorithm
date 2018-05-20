package com.algorithm.sfdl;

import com.algorithm.utils.SortUtils;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/20 0020 12:11
 */
public class Chapter2 {

    /**
     * 2.1-4：有两个各存放在数组A和B中的n位二进制整数，考虑它们的相加问题。两个整数的和以二进制形式存放在具有(n+1)个元素的数组C中。请给出这个问题的形式化描述，并写出伪代码。
     *
     * A存放了一个二进制n位整数的各位数值，B存放了另一个同样是二进制n位整数的各位上的数值，
     * 现在通过二进制的加法对这两个数进行计算，结果以二进制形式把各位上的数值存放在数组C（n+1位）中。注意这里的增加需要考虑进位的问题。
     *
     * 该问题主要是判断一下进位。A[i] + B[i] + C[i], 其中C[i]为进位标志。
     *
     * 一个更简单明了的伪代码：
     * BINARY-ADD(A,B,C)
     *
     * flag = 0 // 需要进位标志
     * for j=1 to n
     *     key=A[j]+B[j]+flag
     *     C[j] = key mod 2
     *     flag = key / 2 // 获得进位
     * */
    public static void practice2_1_4() {

    }

    /**
     * 2.2-2选择排序的实现。
     * 选择排序的思想即是先找出数组A中的最小的元素，并将其与A[1](数组第一个元素，在代码中为a[0])中的元素进行交换。接着找出次最小的元素与A[2]中的元素进行交换。
     * 对数组A中的前n-1个元素执行该操作。该算法最好与最差情况都是O（n^2）。
     */
    public static void practice2_2_2(int[] ints) {
        //伪代码：
        //SELECTION-SORT ( A)
        //n ← length[A]
        //for i← 1 to n − 1
        //  do smallest ←i
        //for j← i+ 1 to n
        //  do if A[j] < A[smallest]
        //    then smallest ← j
        //exchange A[ i] ↔ A[smallest]
        //循环不变式：在每次外层for循环迭代执行前，子数组A[1,2,...i-1]由数组A[1,2, ...n]中最小的i-1个数构成，且已经排好序。
        // for循环执行完前n-1个元素后，A[1,2, ...n-1]包含A中的最小的n-1个元素，且已经排好序。故整个不变式成立。

        selectionSort(ints);
    }

    /**
     * 选择排序算法
     * @param ints
     */
    public static void selectionSort(int[] ints) {
        int n = ints.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (ints[min] > ints[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = ints[i];
                ints[i] = ints[min];
                ints[min] = temp;
            }
        }

        SortUtils.writeTerminalResult("选择", ints);

    }

}
