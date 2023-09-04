package com.Recruitment;

import java.io.IOException;

/**
 * @description: 用1构造任意数字
 * 使用1和加法乘法构造任意数字k，求出使用1的最少可能。
 * 例如2->2.4->4,6>5(2*3构造)
 * 使用动态规划，考虑加法遍历和乘法遍历，加法遍历就是用任意两个数字求和计算最小的1的数量；
 * 乘法遍历就是当取余为0的情况，计算两数消耗的1的数量。
 * @author: Huang Zhiwei
 * @time: 2023/9/3 19:04
 */
public class xmly {
    public static int minimizeOnes(int k) {
        if(k <= 5){
            return k;
        }
        int[] dp = new int[k];
        for(int i =0;i<5;i++){
            dp[i] = i+1;
        }
        for (int i = 6; i <= k; i++) {
            dp[i-1] = dp[i-2]+1; // 初始化为最坏情况
            // 加法遍历
            for (int j = i-1; j >= i/2; j--) {
                dp[i-1] = Math.min(dp[i-1], dp[i-1-j]+dp[j-1]);
            }
            // 乘法遍历
            for(int j = 2;j<i/2;j++){
                if(i%j == 0){
                    dp[i-1] = Math.min(dp[i-1],dp[j-1]+dp[(i/j) -1]);
                }
            }
        }
        return dp[k-1];
    }

    public static void main(String[] args) {
        int k = 11;
        int result = minimizeOnes(k);
        System.out.println("构造数字 " + k + " 所需的最少 1 的数量是：" + result);
    }
}
