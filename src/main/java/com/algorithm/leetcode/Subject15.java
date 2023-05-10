package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/target-sum/
 * 15. 三数之和
 * 难度 中等
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 *
 *
 * 提示：
 *
 *     3 <= nums.length <= 3000
 *     -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 */
public class Subject15 {

    /**
     * 返回所有和为0且不重复数组
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        // 排序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        // 遍历数组
        for (int first = 0; first < n; first++) {
            // 不能相等，从下一个开始计算，且不能与前一个值相等
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 第三个数下标从最后开始
            int three = n - 1;
            // 当前的目标值取反
            int target = -nums[first];
            // 二层遍历
            for (int second = first + 1; second < n; second++) {
                // 不能相等，从下一个开始计算，且不能与前一个值相等
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 第二小于第三个数下标且第二个数加第三个数相加大于第一个数取反，第三个数向左移
                while (second < three && nums[three] + nums[second] > target) {
                    three--;
                }
                // 第二个数和第三个数下标相同，结束
                if (second == three) {
                    break;
                }
                // 第二个数和第三个数相加与第一个数取反相等，添加结果
                if (target == nums[second] + nums[three]) {
                    ans.add(Arrays.asList(nums[first], nums[second], nums[three]));
                }
            }
        }
        return ans;
    }

    @Test
    public void maxAreaTest() {
        Assert.assertEquals(threeSum(new int[]{-1,0,1,2,-1,-4}), Arrays.asList(Arrays.asList(-1,-1,2), Arrays.asList(-1,0,1)));
        Assert.assertEquals(threeSum(new int[]{0,1,1}), Collections.emptyList());
        Assert.assertEquals(threeSum(new int[]{0,0,0}), Arrays.asList(Arrays.asList(0,0,0)));
    }

}
