package com.algorithm.sort;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class TestMain {

    public static void main(String[] args) {

        int[] bubble = new int[]{23, 34, 57, 82, 19, 24, 58, 90, 88};
        new Bubble().sort(bubble);

        int[] cocktail = new int[]{23, 34, 57, 82, 19, 24, 58, 90, 88};
        new Cocktail().sort(cocktail);

        int[] selection = new int[]{23, 34, 57, 82, 19, 24, 58, 90, 88};
        new Selection().sort(selection);

        int[] insertion = new int[]{23, 34, 57, 82, 19, 24, 58, 90, 88};
        new Insertion().sort(insertion);

        int[] binaryInsertion = new int[]{23, 34, 57, 82, 19, 24, 58, 90, 88};
        new BinaryInsertion().sort(binaryInsertion);

        int[] shell = new int[]{23, 34, 57, 82, 19, 24, 58, 90, 88};
        new Shell().sort(shell);

        int[] recursion = new int[]{23, 34, 57, 82, 19, 24, 58, 90, 88};
        int[] iteration = new int[]{23, 34, 57, 82, 19, 24, 58, 90, 88};
        System.out.println("---------------------------------------------");
        new Merge().recursion(recursion, 0, recursion.length - 1);
        System.out.println("---------------------------------------------");
        new Merge().iteration(iteration, iteration.length);

        int[] quick = new int[]{23, 34, 57, 82, 19, 24, 58, 90, 88};
        System.out.println("---------------------------------------------");
        new Quick().sort(quick, 0, quick.length - 1);
        System.out.println("---------------------------------------------");

    }

}
