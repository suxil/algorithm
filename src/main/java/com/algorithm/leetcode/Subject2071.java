package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/target-sum/
 * 2071. 你可以安排的最多任务数目
 * 难度 困难
 *
 * 给你 n 个任务和 m 个工人。每个任务需要一定的力量值才能完成，需要的力量值保存在下标从 0 开始的整数数组 tasks 中，第 i 个任务需要 tasks[i] 的力量才能完成。每个工人的力量值保存在下标从 0 开始的整数数组 workers 中，第 j 个工人的力量值为 workers[j] 。每个工人只能完成 一个 任务，且力量值需要 大于等于 该任务的力量要求值（即 workers[j] >= tasks[i] ）。
 *
 * 除此以外，你还有 pills 个神奇药丸，可以给 一个工人的力量值 增加 strength 。你可以决定给哪些工人使用药丸，但每个工人 最多 只能使用 一片 药丸。
 *
 * 给你下标从 0 开始的整数数组tasks 和 workers 以及两个整数 pills 和 strength ，请你返回 最多 有多少个任务可以被完成。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tasks = [3,2,1], workers = [0,3,3], pills = 1, strength = 1
 * 输出：3
 * 解释：
 * 我们可以按照如下方案安排药丸：
 * - 给 0 号工人药丸。
 * - 0 号工人完成任务 2（0 + 1 >= 1）
 * - 1 号工人完成任务 1（3 >= 2）
 * - 2 号工人完成任务 0（3 >= 3）
 *
 * 示例 2：
 *
 * 输入：tasks = [5,4], workers = [0,0,0], pills = 1, strength = 5
 * 输出：1
 * 解释：
 * 我们可以按照如下方案安排药丸：
 * - 给 0 号工人药丸。
 * - 0 号工人完成任务 0（0 + 5 >= 5）
 *
 * 示例 3：
 *
 * 输入：tasks = [10,15,30], workers = [0,10,10,10,10], pills = 3, strength = 10
 * 输出：2
 * 解释：
 * 我们可以按照如下方案安排药丸：
 * - 给 0 号和 1 号工人药丸。
 * - 0 号工人完成任务 0（0 + 10 >= 10）
 * - 1 号工人完成任务 1（10 + 10 >= 15）
 *
 * 示例 4：
 *
 * 输入：tasks = [5,9,8,5,9], workers = [1,6,4,2,6], pills = 1, strength = 5
 * 输出：3
 * 解释：
 * 我们可以按照如下方案安排药丸：
 * - 给 2 号工人药丸。
 * - 1 号工人完成任务 0（6 >= 5）
 * - 2 号工人完成任务 2（4 + 5 >= 8）
 * - 4 号工人完成任务 3（6 >= 5）
 *
 *
 *
 * 提示：
 *
 *     n == tasks.length
 *     m == workers.length
 *     1 <= n, m <= 5 * 104
 *     0 <= pills <= m
 *     0 <= tasks[i], workers[j], strength <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-number-of-tasks-you-can-assign
 */
public class Subject2071 {

    /**
     * 返回可以安排的最多任务数
     * @param tasks 完成任务需要的力量数组
     * @param workers 工人的力量数组
     * @param pills 神奇药丸数量
     * @param strength 可以增加的力量值
     * @return
     */
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        // 任务左边界
        int l = 0;
        // 任务右边界
        int r = tasks.length;
        // 中间变量
        int m;
        // 可以完成的最多任务数
        int ans = 0;
        while (l <= r) {
            // 计算中间下标
            m = (r + l) / 2;
            // tasks[0...m-1]
            // workers[能力强的m个人]
            if (process(tasks, 0, m - 1, workers, workers.length - m, workers.length - 1, strength) <= pills) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    /**
     * 返回需要吃药丸可以做任务的人数
     * @param tasks
     * @param tl
     * @param tr
     * @param workers
     * @param wl
     * @param wr
     * @param strength
     * @return
     */
    public int process(int[] tasks, int tl, int tr, int[] workers, int wl, int wr, int strength) {
        // 工作数左边界小于0，返回需要无穷个人
        if (wl < 0) {
            return Integer.MAX_VALUE;
        }
        // 有序表记录tasks[tl...tr]出现的次数
        TreeMap<Integer, Integer> taskMap = new TreeMap();
        for (int i = tl; i <= tr; i++) {
            taskMap.put(tasks[i], taskMap.getOrDefault(tasks[i], 0) + 1);
        }
        int ans = 0;
        for (int i = wl; i <= wr; i++) {
            // 获取工作能力小且最近的任务
            Integer job = taskMap.floorKey(workers[i]);
            if (job == null) {
                // 获取吃药丸后工作能力小且最近的任务
                job = taskMap.floorKey(workers[i] + strength);
                // 都无法获取，返回需要无穷个人
                if (job == null) {
                    return Integer.MAX_VALUE;
                }
                // 吃药丸人数加一
                ans++;
            }
            // 获取工作数
            int num = taskMap.get(job);
            // 如果只有一个，移除；否则减一
            if (num == 1) {
                taskMap.remove(job);
            } else {
                taskMap.put(job, num - 1);
            }
        }
        return ans;
    }

    @Test
    public void maxTaskAssignTest() {
        Assert.assertEquals(maxTaskAssign(new int[]{3, 2, 1}, new int[]{0, 3, 3}, 1, 1), 3);
        Assert.assertEquals(maxTaskAssign(new int[]{5,4}, new int[]{0,0,0}, 1, 5), 1);
        Assert.assertEquals(maxTaskAssign(new int[]{10,15,30}, new int[]{0,10,10,10,10}, 3, 10), 2);
        Assert.assertEquals(maxTaskAssign(new int[]{5,9,8,5,9}, new int[]{1,6,4,2,6}, 1, 5), 3);
    }

}
