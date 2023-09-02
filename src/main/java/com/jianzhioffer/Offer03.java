package com.jianzhioffer;

import java.util.HashSet;

/**
 * @description: 找出数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中 任意一个重复的数字。
 * 直接使用哈希
 * @author: Huang Zhiwei
 * @time: 2023/4/7 16:36
 */
public class Offer03 {
    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(input));
    }
    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        for(int x:nums){
            if(hashset.contains(x)) return x;
            else{
                hashset.add(x);
            }
        }
        return 0;
    }
}
