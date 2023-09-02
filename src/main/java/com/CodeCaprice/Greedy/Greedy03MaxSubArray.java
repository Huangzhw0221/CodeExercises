package com.CodeCaprice.Greedy;

/**
 * @description: 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 核心思想是如果当前的连续和是负数就抛弃它，选择下一个数从新开始计算子序和。
 * @author: Huang Zhiwei
 * @time: 2023/9/2 21:45
 */
public class Greedy03MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums){
        int[] maxnums = new int[nums.length];
        maxnums[0] = nums[0];
        int result = nums[0];
        for(int i =1;i<nums.length;i++){
            if(maxnums[i-1]>0){
                maxnums[i] = maxnums[i-1]+nums[i];
            }else {
                maxnums[i] = nums[i];
            }
            result = Math.max(result,maxnums[i]);
        }
        return result;
    }
}
