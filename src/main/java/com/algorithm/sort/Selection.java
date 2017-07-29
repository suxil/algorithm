package com.algorithm.sort;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class Selection {

    public void change(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

    public void sort(int[] ints) {

        for (int i = 0; i < ints.length; i++) {
            int min = i;
            for (int j = i + 1; j < ints.length; j ++) {
                if (ints[min] > ints[j]) {
                    min = j;
                }
            }
            if (min != i) {
                change(ints, min, i);
            }
        }

        System.out.println("选择排序结果：");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ", ");
        }

        System.out.println(".");

    }

    public static void main(String[] args) {

        int[] ints = new int[]{234,239,87,71,83,46,59};

        new Selection().sort(ints);
    }

}
