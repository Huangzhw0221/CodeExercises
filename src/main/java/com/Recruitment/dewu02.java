package com.Recruitment;

import java.util.Scanner;

/**
 * @description: 计算01串中不包含110的最长串的长度
 * 思路就是模拟，先排除两种特殊情况：110 和长度小于3的
 * 然后尝试命中110，命中就记录最大长度
 * 没有命中就移动起点
 * 然后处理末尾问题即可
 * @author: Huang Zhiwei
 * @time: 2023/9/6 20:39
 */
public class dewu02 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String s = in.nextLine();
        char[] arr = s.toCharArray();
        // 子串的头和尾
        int p1 = 0,p2 =0;
        int len = arr.length;
        int maxLen = Integer.MIN_VALUE;
        if(s.equals("110")){
            System.out.println(0);
            return;
        }
        if(len <3){
            System.out.println(len);
            return;
        }
        while (true){
            // 命中110
            if(arr[p2] =='1' && arr[p2+1] =='1' && arr[p2+2] == '0'){
                maxLen = Math.max(maxLen,p2-p1+2);
                p1 = p2 +1;
            }
            // 末尾
            if(p2 +2 == len-1){
                if(arr[p2] !='1' || arr[p2+1] !='1' || arr[p2+2] != '0'){
                    maxLen = Math.max(maxLen,p2-p1+3);
                }
                break;
            }
            p2++;
        }
        System.out.println(maxLen);
    }
}
