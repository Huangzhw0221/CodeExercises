package com.Recruitment;

import java.util.Scanner;

/**
 * 1. @ClassDescription: 字节跳动笔试题
 * 输入两个字符串，可以改动一个数字，计算最大的相似度
 * 相似度的定义是最长的相同前缀和最长的相同后缀的乘积
 *
 * 思路是先计算初始的相速度：找到最长的相同前缀和最长的相同后缀，然后相乘
 * 然后分别计算修改前缀和修改后缀两种情况，计算相似度
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年08月27日 10:05
 */
public class bytedance01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int[] initial = initialSimiarityLength(s,t);
        int maxSim = initial[0]*initial[1];
        String newS = modifiedSimiarityLength(s,t,initial[0],initial[1],initial[2]);
        int[] modified = initialSimiarityLength(newS,t);
        maxSim = Math.max(maxSim,modified[0]*modified[1]);
        System.out.println(maxSim);

    }
    //计算最长相同前缀和后缀
    public static int[] initialSimiarityLength(String s,String t){
        int maxLength = Math.min(s.length(),t.length());
        int a = 0;
        int b = 0;
        boolean flagA = true;
        boolean flagB = true;
        for(int i = 0;i<maxLength;i++){
            if(flagA && s.charAt(i) == t.charAt(i)){
                a += 1;
            }else {
                flagA = false;
            }

            if(flagB && s.charAt(s.length()-1-i) == t.charAt(t.length()-1-i)){
                b += 1;
            }else {
                flagB = false;
            }

            if(!flagA && !flagB){
                break;
            }
        }
        return new int[]{a,b,maxLength};
    }
    public static String modifiedSimiarityLength(String s,String t,int a,int b, int maxLength){
        int modiformer = 0;
        int modilater = 0;
        boolean outofrangeA=false;
        boolean outofrangeB=false;
        if(a < maxLength){
            modiformer = (a+1) * b;
        }else {
            outofrangeA = true;
        }
        if(b < maxLength){
            modilater = a*(b+1);
        }else {
            outofrangeB = true;
        }
        if(outofrangeA && outofrangeB){
            return s;
        }
        if (modiformer > modilater){
            //改动S前缀
            StringBuilder sb = new StringBuilder(s);
            sb.replace(a,a+1, String.valueOf(t.charAt(a)));
            return sb.toString();
        }else{
            //改动S后缀
            StringBuilder sb = new StringBuilder(s);
            sb.replace(s.length()-1-b,s.length()-b, String.valueOf(t.charAt(t.length()-1-b)));
            return sb.toString();
        }
    }
}