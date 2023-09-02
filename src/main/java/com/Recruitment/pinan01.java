package com.Recruitment;

import java.util.Scanner;

/**
 * @description: 中国平安笔试01
 * @author: Huang Zhiwei
 * @time: 2023/9/1 12:18
 */
public class pinan01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // n进制的数
        int n = in.nextInt();
        String s = in.next();
        // 计数器
        int count = 0;
        // 判断是否回文
        while (!ishuiwen(s)){
            count ++;
            if(count == 31){
                System.out.println("Impossible! ");
                return;
            }
            // 正向的转为数字
            long a = Long.parseLong(s,n);
            StringBuilder sb = new StringBuilder(s);
            // 反向的转为数字
            long b = Long.parseLong(sb.reverse().toString(),n);
            long sum = a + b;
            s = Long.toString(sum,n);
        }
        System.out.println("STEP="+count);
    }
    public static boolean ishuiwen(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String reverse = sb.reverse().toString();
        return s.equals(reverse);
    }
}
