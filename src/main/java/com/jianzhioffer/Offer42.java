package com.jianzhioffer;

/**
 * @description: 连续子数组的最大和
 * 动态规划问题，如果前面的子串和小于0，那不如不加，即重置子串和为当前元素；如果前面子串和大于0，那就可以加上
 * @author: Huang Zhiwei
 * @time: 2023/5/2 13:55
 */
public class Offer42 {
    public static void main(String[] args) {
        int[] inputs = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(inputs));
    }
    public static int maxSubArray(int[] nums) {
        int temp = nums[0];
        int max = Math.max(Integer.MIN_VALUE,temp);
        for(int i = 1;i<nums.length;i++){
            if(temp<0){
                temp = nums[i];
            }else {
                temp = nums[i]+temp;
            }
            max = Math.max(temp,max);
        }
        return max;
    }
}
