package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/target-sum/
 * 55. 跳跃游戏
 * 难度 中等
 *
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 3 * 104
 *     0 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game
 */
public class Subject55 {

    /**
     * 是否可以跟跃到最后节点
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        // 只有一个元素时返回true
        if (nums.length == 1) {
            return true;
        }
        // 最右可以到的位置
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            // 计算i最右可以到达的位置与之前最右可以到达的位置取最大值
            r = Math.max(r, i + nums[i]);
            // 如果i>=r，下标超过最右位置时，i没有来到最后一个元素，返回false
            if (i >= r && i != nums.length - 1) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void canJumpTest() {
        Assert.assertTrue(canJump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertFalse(canJump(new int[]{3,2,1,0,4}));
    }

}
