package com.algorithm.sort;

import org.junit.Test;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/20 0020 17:23
 */
public class SortTests {

    @Test
    public void testBinaryInsertionSort() {
        int[] ints = new int[]{234,239,87,71,83,46,59};
        BinaryInsertion.sort(ints);
    }

    @Test
    public void testBubbleSort() {
        int[] ints = new int[]{234,239,87,71,83,46,59};
        Bubble.sort(ints);
    }

    @Test
    public void testCocktailSort() {
        int[] ints = new int[]{234,239,87,71,83,46,59};
        Cocktail.sort(ints);
    }

    @Test
    public void testHeapSort() {
        int[] ints = new int[]{234,239,87,71,83,46,59};
        Heap.sort(ints);
    }

    @Test
    public void testInsertionSort() {
        int[] ints = new int[]{234,239,87,71,83,46,59};
        Insertion.sort(ints);
    }

    @Test
    public void testMergeSort() {
        int[] ints = new int[]{234,239,87,71,83,46,59};
        int[] ints1 = new int[]{234,239,87,71,83,46,59};

        Merge.recursion(ints);
        Merge.iteration(ints1);
    }

    @Test
    public void testQuickSort() {
        int[] ints = new int[]{234,239,87,71,83,46,59};
        Quick.sort(ints);
    }

    @Test
    public void testSelectionSort() {
        int[] ints = new int[]{234,239,87,71,83,46,59};
        Selection.sort(ints);
    }

    @Test
    public void testShellSort() {
        int[] ints = new int[]{234,239,87,71,83,46,59};
        Shell.sort(ints);
    }

}
