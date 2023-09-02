package com.jianzhioffer;

/**
 * @description:  在排序数组中查找数字 I
 * 遍历计数
 * @author: Huang Zhiwei
 * @time: 2023/5/2 15:28
 */
public class Offer53_1 {
    public static void main(String[] args) {
        int[] inputs = {5,7,7,8,8,10};
        System.out.println(search(inputs, 8));
    }
    public static int search(int[] nums, int target) {
        int count = 0;
        for(int x:nums){
            if(x > target){
                break;
            }else if(x == target){
                count++;
            }
        }
        return count;
    }
}
