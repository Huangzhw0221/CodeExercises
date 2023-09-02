package com.CodeCaprice.Array;

/**
 * @description: 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 双指针模拟滑动窗口法，用i标识起始位置，j标识终止位置，先让j出发收集一路上的数值和，直到数值和大于sum；
 * 然后让i往后移动，挨个减去i对应位置的数值，直到数值和比sum小；接下来再移动j，以此类推。
 * @author: Huang Zhiwei
 * @time: 2023/8/31 21:27
 */
public class Array04MinSubArrayLen {
    public static void main(String[] args) {
        int[] arrays = new int[]{1,4,4};
        System.out.println(minSubArrayLen(4,arrays));
    }
    public static int minSubArrayLen(int target,int[] nums){
        int i = 0,j=0,sum = 0,result = Integer.MAX_VALUE;
        while(j < nums.length){
            sum += nums[j];
            while (sum >= target){
                result = Math.min(result,j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
