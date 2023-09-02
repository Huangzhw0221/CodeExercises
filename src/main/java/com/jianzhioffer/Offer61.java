package com.jianzhioffer;

import java.util.Arrays;

/**
 * @description: 扑克牌中的顺子
 * 本体难度很低，就是在条件判断中需要搞清楚一些
 * 用一个赖子计数器计数0；然后从count+1位置开始遍历，出现相同的返回false，赖子小于0返回false，没赖子可用且相差大于1返回false；
 * @author: Huang Zhiwei
 * @time: 2023/5/2 17:04
 */
public class Offer61 {
    public static void main(String[] args) {
//        int[] inputs = {3,10,8,9,10};
        int[] inputs = {9,0,6,0,10};
        System.out.println(isStraight(inputs));
    }
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        //赖子计数器
        int count = 0;
        for(int x:nums){
            count = x == 0 ? count+1:count;
        }
        if(count == 5)return true;
        int former = nums[count];
        for(int i = count+1;i<nums.length;i++){
            if(nums[i] == former+1){
                former = nums[i];
            }else if(nums[i] == former){
                return false;
            }else if(count>0) {
                count = count - (nums[i] - former)+1;
                if (count < 0) {
                    return false;
                }
                former = nums[i];
            }else {
                return false;
            }
        }
        return true;
    }
}
