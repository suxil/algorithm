package com.algorithm.sort;

import com.algorithm.utils.SortUtils;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class Cocktail {

    public static void change(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

    public static void sort(int[] ints) {

        int left = 0;
        int right = ints.length - 1;

        while (left < right) {
            for (int i = left; i < right; i++) {
                if (ints[i] > ints[i + 1]) {
                    change(ints, i, i + 1);
                }
            }
            right --;

            for (int i = right; i > left; i--) {
                if (ints[i - 1] > ints[i]) {
                    change(ints, i - 1, i);
                }

            }
            left ++;
        }

        SortUtils.writeTerminalResult("鸡尾酒", ints);

    }

}
