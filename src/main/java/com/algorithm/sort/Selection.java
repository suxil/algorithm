package com.algorithm.sort;

import com.algorithm.utils.SortUtils;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class Selection {

    public static void sort(int[] ints) {

        for (int i = 0; i < ints.length; i++) {
            int min = i;
            for (int j = i + 1; j < ints.length; j ++) {
                if (ints[min] > ints[j]) {
                    min = j;
                }
            }
            if (min != i) {
                SortUtils.change(ints, min, i);
            }
        }

        SortUtils.writeTerminalResult("选择", ints);

    }

}
