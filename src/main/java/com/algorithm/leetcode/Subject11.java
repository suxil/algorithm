package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/target-sum/
 * 11. 盛最多水的容器
 * 难度 中等
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     n == height.length
 *     2 <= n <= 105
 *     0 <= height[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 */
public class Subject11 {

    /**
     * 返回最多可以盛水数量
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        // 最终结果
        int ans = 0;
        // 左边界
        int l = 0;
        // 右边界
        int r = height.length - 1;
        while (l < r) {
            // 计算最多盛水数量，取最大值
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            // 判断左边高度和右边高度，谁小谁向内移
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    @Test
    public void maxAreaTest() {
        Assert.assertEquals(maxArea(new int[]{1,8,6,2,5,4,8,3,7}), 49);
        Assert.assertEquals(maxArea(new int[]{1,1}), 1);
    }

}
