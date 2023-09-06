package com.Recruitment;

import java.util.Scanner;

/**
 * @description: z字排列
 * 类似原题，详见：leetcode 6 z字形变换
 * 模拟法即可
 * @author: Huang Zhiwei
 * @time: 2023/9/4 20:08
 */
public class shein01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String string = input.split(",")[0];
        int k = Integer.parseInt(input.split(",")[1]);
        System.out.println(trans(string,k));
    }
    public static String trans(String input,int k){
        int n = input.length();
        if(k >= n || k==1){
            return input;
        }
        int t = k*2 - 2;
        int c = (n + t-1)/t*(k-1);
        // 创建字符二维数组
        char[][] chars = new char[k][c];
        for(int i = 0,x=0,y=0;i<n;i++){
            chars[x][y] = input.charAt(i);
            if (i % t < k - 1) {
                x++;
            } else {
                y++;
                x--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char[] row:chars){
            for(char c1:row){
                if(c1 != 0){
                    sb.append(c1);
                }
            }
        }
        return sb.toString();
    }
}
