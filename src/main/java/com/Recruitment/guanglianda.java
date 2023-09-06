package com.Recruitment;

/**
 * @description: 广联达01
 *
 * @author: Huang Zhiwei
 * @time: 2023/9/6 10:32
 */
public class guanglianda {

    public static void main(String[] args) {
        // 起始时刻
        int[] s = {1, 3, 6, 7, 11,12,19};
        // 耗时
        int[] t = {4, 3, 4, 3, 9,4,6};
        // 酬劳
        int[] a = {2, 5, 5, 3, 4,3,3};
        co();
        int maxEarnings = calculateMaxEarnings(s, t, a);
        System.out.println("最多可赚取的酬劳: " + maxEarnings);
    }
    public static int calculateMaxEarnings(int[] s, int[] t, int[] a) {
        int n = s.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int endTime = s[i - 1] + t[i - 1];
            dp[i] = Math.max(dp[i - 1], a[i - 1]);
            for (int j = i - 2; j >= 0; j--) {
                if (s[j] + t[j] <= s[i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j + 1] + a[i - 1]);
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void co(){
        int[] s = {1, 3, 6, 7, 11,12,19};
        // 耗时
        int[] t = {4, 3, 4, 3, 9,4,6};
        // 酬劳
        int[] a = {2, 5, 5, 3, 4,3,3};

        int[][] dp = new int[s.length][2];
        // 0维度该时刻前最多的酬劳
        dp[0][0] = a[0];
        // 1维度表示在该时刻前
        dp[0][1] = s[0]+t[0];
        int maxReward = a[0];
        for (int i = 1; i < s.length; i++) {
            dp[i][1] = t[i]+s[i];
            maxReward = Math.max(a[i],maxReward);
            dp[i][0] = maxReward;
            for(int j = i-1;j>=0;j--){
                if(s[i] >= dp[j][1]){
                    maxReward = Math.max(dp[j][0]+a[i],maxReward);
                    dp[i][0] = maxReward;
                    break;
                }
            }
        }

        System.out.println("可以获得的最大酬劳为：" + maxReward);
    }
}
