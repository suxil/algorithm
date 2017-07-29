package com.algorithm.sort;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class Merge {

    public void merge(int ints[], int l, int mid, int r) {
        int len = r - l + 1;
        int[] temps = new int[len];
        int idx = 0;
        int i = l;
        int j = mid + 1;
        while (i <= mid && j <= r) {
            temps[idx++] = ints[i] <= ints[j] ? ints[i++] : ints[j++];
        }
        while (i <= mid) {
            temps[idx++] = ints[i++];
        }
        while (j <= r) {
            temps[idx++] = ints[j++];
        }
        for (int k = 0; k < len; k ++) {
            ints[l++] = temps[k];
        }
    }

    public void recursion(int[] ints, int l, int r) {

        if (l == r) {
            return;
        }

        int mid = (l + r) / 2;
        recursion(ints, l, mid);
        recursion(ints, mid + 1, r);
        merge(ints, l, mid, r);

        System.out.println("递归实现的归并排序结果：");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ", ");
        }

        System.out.println(".");

    }

    public void iteration(int[] ints, int len) {

        int l, mid, r;

        for (int i = 1; i < len; i *= 2) {
            l = 0;
            while (l + i < len) {
                mid = l + i -1;
                r = mid + i < len ? mid + i : len - 1;
                merge(ints, l, mid, r);
                l = r + 1;
            }
        }

        System.out.println("非递归实现的归并排序结果：");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ", ");
        }

        System.out.println(".");

    }

    public static void main(String[] args) {

        int[] ints = new int[]{234,239,87,71,83,46,59};
        int[] ints1 = new int[]{234,239,87,71,83,46,59};

        Merge merge = new Merge();

        merge.recursion(ints, 0, ints.length - 1);
        merge.iteration(ints1, ints1.length);

    }

}
