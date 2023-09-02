package com.CodeCaprice.Greedy;

/**
 * @description: 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 说明: 假设你总是可以到达数组的最后一个位置
 *
 * 需要用两个变量coverTemp和coverNext来记录当前的最大覆盖和下一步的最大覆盖，因为思路总是跳得越远越好的。
 * 如果当前覆盖没有到达终点，那么必然要再走一步；而在当前覆盖内选取一个下一步覆盖最大的就很重要。
 * 基于这个思路贪心的代码也就很好写了。
 *
 * @author: Huang Zhiwei
 * @time: 2023/9/2 22:09
 */
public class Greedy06Jump {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,0,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        // 长度是1 的情况
        if(nums.length == 1)return 0;
        // 覆盖范围赋初值
        int coverTemp = nums[0];
        int coverNext = nums[0];
        // 计数器从1 步开始计数
        int count = 1;
        // 下标跳过0，从第二个元素看是看起
        int index = 1;
        // 终止条件是下标小于数组长度
        while (index < nums.length ){
            coverNext = Math.max(coverNext,index+nums[index]);
            // 走下一步的条件是下标大于等于当前步的覆盖范围 ，同时下标没有走到最后一格
            if(index >= coverTemp && index < nums.length - 1){
                count++;
                coverTemp = coverNext;
            }
            index ++;
        }
        return count;
    }
}
