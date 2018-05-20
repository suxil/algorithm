package com.algorithm.utils;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/20 0020 17:19
 */
public class SortUtils {

    /**
     * 输出拍结果
     * @param sortName
     * @param ints
     */
    public static void writeTerminalResult(String sortName, int[] ints) {
        System.out.println(sortName + "排序结果：");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
            if (i < ints.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println(".");
            }
        }
    }

    /**
     * 交换两个元素
     * @param ints
     * @param i
     * @param j
     */
    public static void change(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

}
