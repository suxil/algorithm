package com.algorithm.sort;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class Bubble {

    public void sort() {

        int[] ints = new int[]{234,239,87,71,83,46,59};

        for (int i = 0; i < ints.length; i ++) {
            for (int j = i; j < ints.length; j ++) {
                if (ints[i] > ints[j]) {
                    int temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                }
            }
        }

        System.out.println(ints);


    }

    public static void main(String[] args) {
        new Bubble().sort();
    }

}
