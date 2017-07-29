package com.algorithm.sort;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class Heap {

    int heapsize;

    public void change(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

    public void heapify(int[] ints, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest;
        if (leftChild < heapsize && ints[leftChild] > ints[i]) {
            largest = leftChild;
        } else {
            largest = i;
        }
        if (rightChild < heapsize && ints[rightChild] > ints[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            change(ints, i, largest);
            heapify(ints, largest);
        }
    }

    public void buildheap(int[] ints, int len) {
        heapsize = len;
        for (int i = heapsize /2 - 1; i >= 0; i --) {
            heapify(ints, i);
        }
    }

    public void sort(int[] ints, int len) {
        buildheap(ints, len);
        for (int i = len - 1; i >= 1; i--) {
            change(ints, 0, i);
            heapsize--;
            heapify(ints, 0);
        }

        System.out.println("堆排序结果：");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ", ");
        }

        System.out.println(".");

    }

    public static void main(String[] args) {

        int[] ints = new int[]{234,239,87,71,83,46,59};

        new Heap().sort(ints, ints.length);

    }

}
