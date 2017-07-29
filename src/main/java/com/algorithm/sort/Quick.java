package com.algorithm.sort;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class Quick {

    public void change(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

    public int partition(int[] ints, int l, int r) {
        int pivot = ints[r];
        int tail = l - 1;
        for (int i = l; i < r; i++) {
            if (ints[i] <= pivot) {
                tail ++;
                change(ints, tail, i);
            }
        }
        change(ints, tail + 1, r);

        return tail + 1;
    }

    public void sort(int[] ints, int l, int r) {
        int idx;
        if (l < r) {
            idx = partition(ints, l, r);
            sort(ints, l, idx - 1);
            sort(ints, idx + 1, r);
        }

        System.out.println("快速排序结果：");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ", ");
        }

        System.out.println(".");

    }

    public static void main(String[] args) {

        int[] ints = new int[]{234,239,87,71,83,46,59};

        new Quick().sort(ints, 0, ints.length - 1);

    }

}
