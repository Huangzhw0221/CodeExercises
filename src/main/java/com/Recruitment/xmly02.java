package com.Recruitment;

/**
 * @description: 用1构造任意数字
 * 使用1和加法乘法构造任意数字k，求出使用1的最少可能。
 * 例如2->2.4->4,6>5(2*3构造)
 * 使用动态规划，考虑加法遍历和乘法遍历，加法遍历就是用任意两个数字求和计算最小的1的数量；
 * 乘法遍历就是当取余为0的情况，计算两数消耗的1的数量。
 * @author: Huang Zhiwei
 * @time: 2023/9/3 19:04
 */
/**
 * 1. @ClassDescription:喜马拉雅
 *只用数字1，用乘法和加法，计算最少用多少个数字1可以构造出输入的数字。
 *思路就是计算：加法和乘法哪个更少，有点像动态规划，其中穿插一个乘法分解
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年09月03日19:43
 */
public class xmly02 {
    public static void main(String[] args) {
        System.out.println(times(11));
    }
    // dp
    public static int times(int k){
        if(k <= 5){
            return k;
        }
        int[] dp = new int[k];
//前五个赋值
        for(int i = 0;i<5;i++){
            dp[i] = i+1;
        }
//从数字6开始计算，也就是dp[5]
        for(int i = 6;i<k+1;i++){
            dp[i-1] = dp[i-2]+1;
//加法分解dp
            for(int j = i-1;j>=0;j--){
                dp[i-1] = Math.min(dp[i-1],dp[j]+i-j);
            }
//乘法分解dp
            for(int j = 2;j<(i/2);j++){
                if(i%j == 0){
                    dp[i-1] = Math.min(dp[i-1],dp[j-1]+dp[(i/j)-1]);
                }
            }
        }
        return dp[k-1];
    }
}

