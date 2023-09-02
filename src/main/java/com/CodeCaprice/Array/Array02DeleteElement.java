package com.CodeCaprice.Array;

/**
 * @description: 移除元素
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并**原地**修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 双指针写法，慢指针找到要删除的数字V的位置，然后等待；
 * 快指针向后走，将找到的第一个不是V的数字，然后赋给慢指针指向的位置。
 * @author: Huang Zhiwei
 * @time: 2023/8/31 17:07
 */
public class Array02DeleteElement {
    public static void main(String[] args) {
        int[] arrays = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arrays,2));
    }
    public static int removeElement(int[] nums, int val) {
        int fast = 0,slow = 0;
        while (fast<nums.length){
            if(nums[fast] == val){
                fast ++;
            }else {
                nums[slow] = nums[fast];
                fast ++;
                slow ++;
            }
        }
        return slow;
    }
}
