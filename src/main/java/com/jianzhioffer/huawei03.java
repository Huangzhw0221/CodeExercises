package com.jianzhioffer;

import java.util.Scanner;

/**
 * @description: 差分数组统计区间，然后遍历区间
 * @author: Huang Zhiwei
 * @time: 2023/4/19 22:51
 */
public class huawei03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] time = new int[n][2];
        int[] diff = new int[ 1000002];
        int end = 0;
        int start = 1000002;
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            time[i][0] = s;
            time[i][1] = e;
            end = Math.max(end, e);
            start = Math.min(start, s);
            diff[s] += 1;
            diff[e+1] -= 1;
        }
        int[] res = new int[end+1];
        res[0] = diff[0];
        for(int i = 1;i<end+1;i++){
            res[i] += res[i - 1] + diff[i];
        }
        int ans = 0;
        for(int i = start;i<res.length;i++){
            switch (res[i]){
                case 0:ans+=1;continue;
                case 1:ans+=3;continue;
                default:ans+=4;
            }
        }
        System.out.println(ans);
    }
}
