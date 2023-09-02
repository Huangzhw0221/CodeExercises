package com.jianzhioffer;

/**
 * @description: 翻转单词顺序'
 * 先将首尾空格去除，再构造StringBuilder，最后输出的时候去除尾部空格
 * @author: Huang Zhiwei
 * @time: 2023/5/2 16:44
 */
public class Offer58_1 {
    public static void main(String[] args) {
        String input = "a good   example";
        System.out.println(reverseWords(input));
    }
    public static String reverseWords(String s) {
        s = s.trim();
        String[] sString = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = sString.length-1;i>=0;i--){
            if(sString[i].equals("")) continue;
            sb.append(sString[i]+" ");
        }
        return sb.toString().trim();
    }
}
