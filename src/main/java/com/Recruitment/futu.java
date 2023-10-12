package com.Recruitment;

import java.util.Arrays;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/10/7 11:40
 */
public class futu {
    public static void main(String[] args) {
        int[] nums = {2,2,1,9};
        System.out.println(count2(nums,10));
    }
    public static int count(int[] nums,int target){
        int result = 0;
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                result = nums[i] + nums[j] <= target ? result +1:result;
            }
        }
        return result;
    }
    public static int count2(int[] nums,int target){
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0;i< nums.length-1;i++){
            for(int j = nums.length-1;j>i;j--){
                if(nums[i] + nums[j] <= target){
                    result = result + j - i ;
                    break;
                }
            }
        }
        return result;
    }
}
