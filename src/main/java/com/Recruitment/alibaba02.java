package com.Recruitment;

import java.util.Scanner;

/**
 * @description: 合法字符串问题
 * 不合法的情况：两个相同的字母挨着两个相同的字母 如aabb
 * 三个相同的字母 如aaa
 * 求需要删除多少个字母才能让字符串变得合法
 * @author: Huang Zhiwei
 * @time: 2023/9/23 19:38
 */
public class alibaba02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        // 删除是三个或多个连续的情况
        String modifiedInput = removeConsecutiveChars(input);
        // 删除两个紧挨着的情况
        int count = removeDoubleChars(modifiedInput);
        System.out.println(input.length()-modifiedInput.length() + count);
    }
    public static String removeConsecutiveChars(String input) {
        StringBuilder sb = new StringBuilder();
        int len = input.toCharArray().length;
        int num = 1;
        char[] chars = input.toCharArray();
        char currChar = '\0';

        for (int i = 0; i < len; i++) {
            if (currChar != chars[i]) {
                currChar = chars[i];
                num = 1;
                sb.append(chars[i]);
                continue;
            }
            if (num > 1) continue;
            num++;
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static int removeDoubleChars(String str){
        int count = 0;
        int former = 0;
        int temp =0;
        for (int i = 0; i < str.length()-1 ; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                temp=2;
                if(former ==2){
                    count++;
                    temp =1;
                }
            } else {
                former = temp;
                temp = 1;
            }
        }
        return count;
    }
}
