package com.Recruitment;

import java.util.Scanner;

/**
 * @description: 科大讯飞
 * 似乎是一个字符串的问题
 * 但是题目忘记了
 * @author: Huang Zhiwei
 * @time: 2023/9/9 15:07
 */
public class kdxf02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        compress(str);
    }
    public static void compress(String str){
        char[] charArr = str.toCharArray();
        int len = charArr.length;
        StringBuilder sb = new StringBuilder();
        char currChar = charArr[0];
        int tmpCount = 1;
        for(int i =1;i<len;i++){
            if(i == len -1){
                if(charArr[i] == charArr[i-1]){
                    sb.append(++tmpCount);
                    sb.append(currChar);
                }else{
                    sb.append(tmpCount);
                    sb.append(charArr[i-1]);
                    sb.append(1);
                    sb.append(charArr[i]);
                }
            }else {
                if(charArr[i] != currChar){
                    sb.append(tmpCount);
                    sb.append(currChar);
                    currChar = charArr[i];
                    tmpCount =1;
                }else {
                    tmpCount ++;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
