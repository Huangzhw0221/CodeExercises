package com.Recruitment;

import java.util.Scanner;

/**
 * @description: 满帮03
 * 反转字符串 30% 也不知道为什么超时
 * @author: Huang Zhiwei
 * @time: 2023/9/24 14:58
 */
public class manbang03 {
    public static String s;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        s = in.next();
        for(int i = 1;i<=n-k+1;i++){
            helper(i-1,i+k-2);
        }
        System.out.println(s);
    }
    public static void helper(int start,int end){
        StringBuilder sb = new StringBuilder(s.substring(0,start));
        StringBuilder temp = new StringBuilder(s.substring(start,end+1)).reverse();
        sb.append(temp).append(s.substring(end+1));
        s = sb.toString();
    }
}
