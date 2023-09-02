package com.jianzhioffer;

/**
 * @description: 第一个只出现一次的字符
 * 只出现小写字母，就创建长度为26的数组；两次遍历，第一次遍历，计数；第二次遍历，找到第一个出现的字符
 * @author: Huang Zhiwei
 * @time: 2023/5/2 14:18
 */
public class Offer50 {
    // 计数数组
    public char firstUniqChar(String s) {
        //只出现小写字母，就创建长度为26的数组
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        //第一次遍历，计数
        for (char c : chars) count[c - 'a']++;
        //第二次遍历，找到第一个
        for (char c : chars) {
            if (count[c - 'a'] == 1) return c;
        }
        return ' ';
    }
}
