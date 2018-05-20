package com.algorithm.sort;

import com.algorithm.utils.SortUtils;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class Shell {

    public static void sort(int[] ints) {

        int temp;

        int h = 0;
        while (h <= ints.length) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < ints.length; i ++) {
                int j = i - h;
                temp = ints[i];
                while ((j >= 0) && (ints[j] > temp)) {
                    ints[j + h] = ints[j];
                    j = j - h;
                }
                ints[j + h] = temp;
            }
            h = (h - 1) / 3;
        }

        SortUtils.writeTerminalResult("希尔", ints);

    }

}
