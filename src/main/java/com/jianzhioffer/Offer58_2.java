package com.jianzhioffer;

/**
 * @description: 左旋转字符串
 * StringBuilder构造字符串，非常简单
 * @author: Huang Zhiwei
 * @time: 2023/5/2 16:53
 */
public class Offer58_2 {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseLeftWords(s, 2));
    }
    public static String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s.substring(n));
        sb.append(s.substring(0,n));
        return sb.toString();
    }
}
