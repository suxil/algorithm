package com.algorithm.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/target-sum/
 * 494. 目标和
 * 难度 中等
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 *     例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 *
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 20
 *     0 <= nums[i] <= 1000
 *     0 <= sum(nums[i]) <= 1000
 *     -1000 <= target <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/target-sum
 */
public class Subject494 {

    /**
     * 暴力递归解
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays1(int[] nums, int target) {
        return process1(nums, 0, target);
    }

    /**
     * 暴力递归
     * @param nums
     * @param i
     * @param target
     * @return
     */
    public int process1(int[] nums, int i, int target) {
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }
        return process1(nums, i + 1, target - nums[i]) + process1(nums, i + 1, target + nums[i]);
    }

    /**
     * 动态规划
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays2(int[] nums, int target) {
        return process2(nums, 0, target, new HashMap<>());
    }

    /**
     * 动态规划
     * @param nums
     * @param i
     * @param target
     * @return
     */
    public int process2(int[] nums, int i, int target, HashMap<Integer, HashMap<Integer, Integer>> dp) {
        if (dp.containsKey(i) && dp.get(i).containsKey(target)) {
            return dp.get(i).get(target);
        }
        if (!dp.containsKey(i)) {
            dp.put(i, new HashMap<>());
        }
        int res = 0;
        if (i == nums.length) {
            res = target == 0 ? 1 : 0;
        } else {
            res = process2(nums, i + 1, target - nums[i], dp) + process2(nums, i + 1, target + nums[i], dp);
        }
        dp.get(i).put(target, res);
        return dp.get(i).get(target);
    }

    /**
     * 优化
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int nv = Math.abs(nums[i]);
            arr[i] = nv;
            sum += nv;
        }
        target = Math.abs(target);
        return sum < target || ((sum & 1) ^ (target & 1)) != 0 ? 0 : subset(arr, (sum + target) >> 1);
    }

    /**
     * 背包问题动态规划
     * @param nums
     * @param s
     * @return
     */
    public int subset(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[s];
    }

}
