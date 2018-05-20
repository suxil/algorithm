package com.algorithm.sort;

import com.algorithm.utils.SortUtils;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class Quick {

    public static int partition(int[] ints, int l, int r) {
        int pivot = ints[r];
        int tail = l - 1;
        for (int i = l; i < r; i++) {
            if (ints[i] <= pivot) {
                tail ++;
                SortUtils.change(ints, tail, i);
            }
        }
        SortUtils.change(ints, tail + 1, r);

        return tail + 1;
    }

    public static void sort(int[] ints, int l, int r) {
        int idx;
        if (l < r) {
            idx = partition(ints, l, r);
            sort(ints, l, idx - 1);
            sort(ints, idx + 1, r);
        }
    }

    public static void sort(int[] ints) {
        sort(ints, 0, ints.length - 1);

        SortUtils.writeTerminalResult("快速", ints);

    }

}
