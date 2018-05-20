package com.algorithm.sort;

import com.algorithm.utils.SortUtils;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class Bubble {

    public static void sort(int[] ints) {

        for (int i = 0; i < ints.length; i ++) {
            for (int j = i; j < ints.length; j ++) {
                if (ints[i] > ints[j]) {
                    int temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                }
            }
        }

        SortUtils.writeTerminalResult("冒泡", ints);

    }

}
