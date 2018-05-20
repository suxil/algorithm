package com.algorithm.sfdl;

import com.algorithm.sort.Merge;
import com.algorithm.utils.SortUtils;
import org.junit.Test;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/20 0020 12:21
 */
public class Chapter2Tests {

    @Test
    public void testPractice2_2_2() {

        int[] ints = new int[]{234,239,87,71,83,46,59};

        Chapter2.practice2_2_2(ints);

    }

    @Test
    public void testPractice2_2_3() {

//        int[] ints = new int[]{2,4,5,7,1,2,3,6};
        int[] ints = new int[]{71,87,234,239,46,59,83};

//        Merge.merge(ints, 0, ints.length / 2 - 1, ints.length - 1);
//        SortUtils.writeTerminalResult("merge", ints);
//        Chapter2.merge(ints, 0, ints.length / 2, ints.length);

        Chapter2.mergeSort(ints);
        SortUtils.writeTerminalResult("归并", ints);

    }

}
