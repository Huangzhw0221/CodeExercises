package com.CodeCaprice.Array;

import java.util.Arrays;

/**
 * @description: 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 思路1：直接平方然后排序
 *
 * 思路2：用两个指针直线该数组的首尾，然后移动指针，向结果集中挨个添加更大的那个数值即可。
 * @author: Huang Zhiwei
 * @time: 2023/8/31 20:58
 */
public class Array03ArraySquare {
    public static void main(String[] args) {
        int[] arrays = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquaresA(arrays)));
        System.out.println(Arrays.toString(sortedSquaresB(arrays)));
    }
    public static int[] sortedSquaresA(int[] nums){
        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            result[i] = nums[i]*nums[i];
        }
        Arrays.sort(result);
        return result;
    }
    public static int[] sortedSquaresB(int[] nums){
        int left = 0,right = nums.length-1;
        int[] result = new int[nums.length];
        for(int i = nums.length-1;i>=0;i--){
            if(nums[left]*nums[left] > nums[right]*nums[right]){
                result[i] = nums[left]*nums[left];
                left ++;
            }else {
                result[i] = nums[right]*nums[right];
                right --;
            }
        }
        return result;
    }
}
