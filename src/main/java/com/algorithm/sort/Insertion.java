package com.algorithm.sort;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class Insertion {

    public void sort(int[] ints) {

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

        System.out.println("插入排序结果：");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ", ");
        }

        System.out.println(".");

    }

    public static void main(String[] args) {

        int[] ints = new int[]{234,239,87,71,83,46,59};

        new Insertion().sort(ints);
    }

}
