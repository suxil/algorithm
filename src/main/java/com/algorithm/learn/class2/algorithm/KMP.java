package com.algorithm.learn.class2.algorithm;

import org.junit.Test;

public class KMP {

    /**
     * 获取字符串2在字符串1中匹配的位置
     * @param s1
     * @param s2
     * @return
     */
    public int getIndex(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() < s2.length()) {
            return -1;
        }

        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        int[] next = getNextArr(sc2);

        // s1 字符匹配的位置
        int i = 0;
        // s2 字符匹配的位置
        int ni = 0;
        while (i < sc1.length && ni < sc2.length) {
            if (sc1[i] == sc2[ni]) {
                // 两个位置相等，进行下一个字符匹配
                i++;
                ni++;
            } else if (next[ni] != -1) {
                // ni索引位置没有来到0位置，也就是s2字符串匹配位置没有来到0位置，使用前一个前缀和后缀最长的位置进行匹配
                ni = next[ni];
            } else {
                // s2 0位置与i位置没有匹配的字符，使用s1的下一个位置进行匹配
                i++;
            }
        }
        // 查看ni是否和s2字符长度相同，相同返回i-ni就是起始匹配位置，否则返回0
        return ni == sc2.length ? i - ni : -1;
    }

    /**
     * 计算next数组
     * 计算除下标位置之前的字符中最长前缀和后缀相等的长度
     * @param cs
     * @return
     */
    public int[] getNextArr(char[] cs) {
        if (cs.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[cs.length];
        next[0] = -1;
        next[1] = 0;

        // 初始位置从2开始
        int i = 2;
        // cs字符数组中和i位置进行匹配的位置
        int cn = 0;
        while (i < cs.length) {
            if (cs[i -1] == cs[cn]) {
                // i-1位置字符与cn字符相同
                next[i++] = ++cn;
            } else if (cn > 0) {
                // 找前一个cn位置开始匹配。出现有效情况比较简单的例子如：aaaaaaaabd
                cn = next[cn];
            } else {
                // 没有匹配的前缀和后缀
                next[i++] = 0;
            }
        }
        return next;
    }

    @Test
    public void getNextArrTest() {
        KMP kmp = new KMP();
        String s2 = "aabaabc";
        int[] next = kmp.getNextArr(s2.toCharArray());
        System.out.println();
    }

    @Test
    public void getIndexTest() {
        KMP kmp = new KMP();

        String s1 = "aacaabaabcef";
//        String s2 = "abcabce";
        String s2 = "aabaabc";
//        int[] next = kmp.getNextArr(s2.toCharArray());

        int i = kmp.getIndex(s1, s2);
        System.out.println();
    }

}
