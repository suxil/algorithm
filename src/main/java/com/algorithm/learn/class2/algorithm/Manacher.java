package com.algorithm.learn.class2.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class Manacher {

    /**
     * 返回最大回文长度
     * @param s
     * @return
     */
    public int manacher(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        char[] cs = manacherChar(s.toCharArray());

        // 回文半径数组
        int[] preArr = new int[cs.length];
        // 回文半径最右位置
        int r = -1;
        // 加文中心
        int c = -1;
        // 回文最大长度
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < cs.length; i++) {
            // 如果i在最大回文半径中，计算i'位置和i~r位置的长度取最小值
            // 否则回文半径为1，没有加速
            preArr[i] = r > i ? Math.min(preArr[2 * c - i], r - i) : 1;
            // i位置两头没有越界，进行比较
            while (preArr[i] + i < cs.length && i - preArr[i] > -1) {
                if (cs[preArr[i] + i] == cs[i - preArr[i]]) {
                    // 对称位置相等
                    preArr[i]++;
                } else {
                    break;
                }
            }
            // 回文半径最右的位置变更大了，更新最右位置和中心位置
            if (i + preArr[i] > r) {
                r = i + preArr[i];
                c = i;
            }
            // 当前位置回文最大长度和回文半径数组中比较取最大值
            max = Math.max(max, preArr[i]);
        }

        return max - 1;
    }

    /**
     * 返回中间添加特殊字符的char数组
     * @param chars
     * @return
     */
    public char[] manacherChar(char[] chars) {
        char[] cs = new char[2 * chars.length + 1];
        cs[0] = '#';
        for (int i = 0; i < chars.length; i++) {
            cs[2 * i + 1] = chars[i];
            cs[2 * i + 2] = '#';
        }
        return cs;
    }

    @Test
    public void manacherCharTest() {
        String s = "aabds";
        char[] cs = manacherChar(s.toCharArray());
        System.out.println();
    }

    @Test
    public void manacherTest() {
        String s = "abcba";
        int l = manacher(s);
        Assert.assertEquals(5, l);
    }

}
