package com.algorithm.sort;

import com.algorithm.utils.SortUtils;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class Insertion {

    public static void sort(int[] ints) {

        int j, temp;

        for (int i = 0; i < ints.length; i++) {
            temp = ints[i];
            j = i - 1;
            while (j >= 0 && ints[j] > temp) {
                ints[j + 1] = ints[j];
                j --;
            }
            ints[j + 1] = temp;
        }

        SortUtils.writeTerminalResult("插入", ints);

    }

}
