package com.Recruitment;

/**
 * 1. @ClassDescription:广联达
 *最大利润问题，s是起始时刻，t是任务耗时，a是任务报酬
 *经典动态规划问题，需要注意的是dp的定义是当前任务参与运算的情况下，最大的报酬是多少
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年09月06日14:22
 */
public class guanglianda01 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int count = in.nextInt();
//        long[] s = new long[count];
//        long[] t = new long[count];
//        long[] a = new long[count];
//        for(int i = 0;i<count;i++){
//            s[i] = Long.parseLong(in.next());
//        }
//        for(int i = 0;i<count;i++){
//            t[i] = Long.parseLong(in.next());
//        }
//        for(int i = 0;i<count;i++){
//            a[i] = Long.parseLong(in.next());
//        }

        long[] s = {1, 3, 6, 7, 11, 12,19};
        long[] t = {4, 3, 4, 3, 9, 4,6};
        long[] a = {2, 5, 5, 3, 4, 3,3};
        caculate(s,t,a);
    }
    public static void caculate(long[] s,long[] t,long[] a){
        long[][] dp = new long[s.length][2];
// 0维度存放该时刻的最多的酬劳
        dp[0][0] = a[0];
// 1维度存放在该时刻前
        dp[0][1] = s[0]+t[0];
        long maxReward = a[0];
        for(int i = 1;i<s.length;i++){
            dp[i][1] = t[i]+s[i];
            maxReward = Math.max(a[i],maxReward);
            dp[i][0] = a[i];
            for(int j = i-1;j>=0;j--){
                if(s[i] >= dp[j][1]){
                    long former = dp[j][0];
                    dp[i][0] = Math.max(former+a[i],dp[i][0]);
                    maxReward = Math.max(dp[i][0],maxReward);
                }
            }
        }
        System.out.println(maxReward);
    }
}
