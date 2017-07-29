package com.algorithm.sort;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class Shell {

    public void sort(int[] ints) {

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

        System.out.println("希尔排序结果：");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ", ");
        }

        System.out.println(".");

    }

    public static void main(String[] args) {

        int[] ints = new int[]{234,239,87,71,83,46,59};

        new Shell().sort(ints);
    }

}
