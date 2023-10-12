package com.Recruitment;

import java.util.Scanner;

/**
 * @description: 中金所02
 * @author: Huang Zhiwei
 * @time: 2023/9/22 19:35
 */
public class zhongjinsuo02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // dp数组 计算斐波那契数列
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i =2;i<=n;i++){
            dp[i] = dp[i-1] +dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
