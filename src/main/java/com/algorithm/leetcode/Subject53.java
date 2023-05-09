package com.algorithm.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/target-sum/
 * 53. 最大子数组和
 * 难度 中等
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 105
 *     -104 <= nums[i] <= 104
 *
 *
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-subarray
 */
public class Subject53 {

    /**
     * 最大子数组和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // 长度等于1返回第一个
        if (nums.length == 1) {
            return nums[0];
        }
        // 前一个最大累加和
        int pre = nums[0];
        // 最大值为第一个元素
        int max = nums[0];
        // 遍历所有元素
        for (int i = 1; i < nums.length; i++) {
            // 当前元素和当前元素加上前一个最大累加和，取最大值
            pre = Math.max(pre + nums[i], nums[i]);
            // i下标的最大累加和与前一个最大累加和，取最大值
            max = Math.max(max, pre);
        }
        return max;
    }

}
