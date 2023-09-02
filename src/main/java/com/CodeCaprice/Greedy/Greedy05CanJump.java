package com.CodeCaprice.Greedy;

/**
 * @description: 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 思路是将跳跃问题转变为范围覆盖问题，使用一个变量cover表示可以覆盖的下标，
 * 然后用while循环在下标小于cover的情况下尽可能多地向后走。
 * @author: Huang Zhiwei
 * @time: 2023/9/2 22:03
 */
public class Greedy05CanJump {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int cover = 0;
        int index = 0;
        while (index <= cover){
            cover = Math.max(cover,index+nums[index]);
            index ++;
            if(cover >= nums.length-1){
                return true;
            }
        }
        return false;
    }
}
