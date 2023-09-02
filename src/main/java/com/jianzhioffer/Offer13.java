package com.jianzhioffer;

/**
 * @description: 机器人的运动范围
 * @author: Huang Zhiwei
 * @time: 2023/4/19 10:56
 */
public class Offer13 {
    public static void main(String[] args) {

    }
    public static int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        vis[0][0] = true;
        for(int i = 0;i<m;i++){
            for(int j= 0;j<n;j++){
                //判断那种情况是不行的，一种是ij=0，因为已经作为计数记过了，一种是加起来大于阈值了
                if((i==0 && j==0) || get(i)+get(j) >k){
                    continue;
                }
                //为二维的可达数组赋值,先判断可达
                if(i-1 >=0){
                    vis[i][j] |= vis[i-1][j];
                }
                if(j-1 >=0){
                    vis[i][j] |= vis[i][j-1];
                }
                if(vis[i][j]){
                    ans ++;
                }
            }
        }
        return ans;
    }
    private static int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
