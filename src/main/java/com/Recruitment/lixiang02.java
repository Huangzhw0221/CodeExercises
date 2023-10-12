package com.Recruitment;

import java.util.ArrayList;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/9/30 19:47
 */
public class lixiang02 {
    public static void main(String[] args) {

    }
    public static int lengthOfLIS (ArrayList<Integer> nums) {
        // write code here
        int[] dp = new int[nums.size()];
        int res = 1;
        dp[0] =1;
        for(int i =1;i<nums.size();i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums.get(j) < nums.get(i)){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
