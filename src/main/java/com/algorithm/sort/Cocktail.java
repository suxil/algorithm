package com.algorithm.sort;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class Cocktail {

    public void change(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

    public void sort(int[] ints) {

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

        System.out.println("鸡尾酒排序结果：");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ", ");
        }

        System.out.println(".");

    }

    public static void main(String[] args) {

        int[] ints = new int[]{234,239,87,71,83,46,59};

        new Cocktail().sort(ints);
    }

}
