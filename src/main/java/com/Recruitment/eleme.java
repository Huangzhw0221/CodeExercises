package com.Recruitment;

import java.util.Scanner;

/**
 * 1. @ClassDescription:饿了么笔试题
 *一个三进制数x，想知道比x大的最小的三进制数，满足邻位都不同。
 *思路就是找到第一个进位的地方在哪里，找到第一个进位，在进位之后就取最小的模式即0101...
 *难点是出现2进位，进位成3，那就要再向前进位，这一步不会做了
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年09月08日19:35
 */
public class eleme {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        int former = 0;
        int temp = 0;
        int index =0;
        StringBuilder sb = new StringBuilder();
//目的是找到最后一位不用修改的地方
        for(int i = 0;i<input.length();i++){
            temp = Integer.parseInt(String.valueOf(input.charAt(i)));
            if(temp == former){
                index = i;
                temp += 1;
//                if(temp == 3){
//                    //进位
//
//                }
                break;
            }
            former = temp;
        }
        sb.append(input.substring(0,index));
//出现一次进位就调用生成最小的哪个函数；
        sb.append(generateLowerest(input.length()-index,temp));
        System.out.println(sb.toString());
    }
    //    public static String dealwithjinwei(String s,int index){
//        s =
//    }
    public static String generateLowerest(int length,int start){
        int times = length/2;
        StringBuilder sb = new StringBuilder();
        String c;
        if (start  == 1){
            c = "10";
            for(int i = 0;i<times;i++){
                sb.append(c);
            }
        }else if(start == 2){
            c="20";
            sb.append(c);
            c = "10";
            for(int i = 0;i<times-1;i++){
                sb.append(c);
            }
        }
        int re = length%2;
        if(re == 1){
            sb.append("1");
        }
        return sb.toString();
    }
}

