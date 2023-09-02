package com.jianzhioffer;

import java.util.Arrays;

/**
 * @description: 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分
 * @author: Huang Zhiwei
 * @time: 2023/4/19 11:43
 */
public class Offer21 {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        System.out.println(Arrays.toString(exchange(nums)));
    }
    public static int[] exchange(int[] nums) {
        if(nums.length <= 1){
            return nums;
        }
        int left = -1;
        int right = nums.length;
        boolean leftisji = true;
        boolean rightisou = true;
        //先动后面的
        while (left<right && right >0 && left <nums.length-1){
            if(rightisou){
                right--;
                rightisou = (nums[right] %2 ==0); //偶数true，直接下一个，奇数false
                continue;
            }
            if(leftisji){
                left++;
                leftisji = (nums[left] %2 ==1); //偶数true，奇数false
                continue;
            }
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            rightisou = true;
            leftisji = true;
        }
        return nums;
    }
}
