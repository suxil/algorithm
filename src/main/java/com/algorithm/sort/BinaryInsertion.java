package com.algorithm.sort;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class BinaryInsertion {

    public void sort(int[] ints) {

        int temp, l, r, middle;

        for (int i = 0; i < ints.length; i ++) {
            temp = ints[i];
            l = 0;
            r = i - 1;
            while (l <= r) {
                middle = (l + r) / 2;
                if (ints[middle] > temp) {
                    r = middle - 1;
                } else {
                    l = middle + 1;
                }
            }

            for (int j = i - 1; j >= l; j --) {
                ints[j + 1] = ints[j];
            }
            ints[l] = temp;
        }

        System.out.println("二分插入排序结果：");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ", ");
        }

        System.out.println(".");

    }

    public static void main(String[] args) {

        int[] ints = new int[]{234,239,87,71,83,46,59};

        new BinaryInsertion().sort(ints);
    }

}
