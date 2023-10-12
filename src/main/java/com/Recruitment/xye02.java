package com.Recruitment;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 背包问题，求出重量为m的组合数
 * @author: Huang Zhiwei
 * @time: 2023/9/18 19:38
 */
public class xye02 {
    public static int sum = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int count =in.nextInt();
        int[] weight = new int[count];
        for(int i =0;i<count;i++){
            weight[i] = in.nextInt();
        }
        Arrays.sort(weight);

        helper(weight,m,0,weight.length);
        System.out.println(sum);
    }
    public static void helper(int[] weight,int m,int begin,int len){
        if(m == 0){
            sum +=1;
            return;
        }
        for(int i = begin;i<len;i++){
            if(m - weight[i] < 0)break;
//            if(i >begin && weight[i] == weight[i-1])continue;
            helper(weight,m-weight[i],i+1,len);
        }
    }
}
