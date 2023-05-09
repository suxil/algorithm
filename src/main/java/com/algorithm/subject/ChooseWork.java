package com.algorithm.subject;

import java.util.Arrays;
import java.util.TreeMap;

public class ChooseWork {

    public class Job {
        public int hard;
        public int money;

        public Job(int h, int m) {
            hard = h;
            money = m;
        }
    }

    /**
     * 返回获取的最大报酬
     * @param job 工作数组，包含难度和获得的报酬，不限人数
     * @param ability 工作能力数组
     * @return 能力数组对应的最大报酬数组
     */
    public static int[] getMoneys(Job[] job, int[] ability) {
        // 根据难度和金额排序，难度小的在前面，相同难度下金额大的在前面
        Arrays.sort(job, ((o1, o2) -> o1.hard != o2.hard ? o1.hard - o2.hard : o1.money - o2.money));
        // 有序表，构建难度和报酬的单调性，难度递增 -> 报酬递增
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Job pre = job[0];
        treeMap.put(pre.hard, pre.money);
        for (int i = 1; i < job.length; i++) {
            // 忽略难度大，报酬低的工作
            if (job[i].hard != pre.hard && job[i].money > pre.money) {
                pre = job[i];
                treeMap.put(pre.hard, pre.money);
            }
        }

        // 金额数组
        int[] ans = new int[ability.length];
        for (int i = 0; i < ability.length; i++) {
            // 获取能力比ability[i]小，最近的的工作
            Integer k = treeMap.floorKey(ability[i]);
            ans[i] = k != null ? treeMap.get(k) : 0;
        }
        return ans;
    }

}
