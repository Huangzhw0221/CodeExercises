package com.Recruitment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @description: 科大讯飞
 * 一个数字串，有一个数字出现a次，其余数字出现b次，找到这个出现a次的数字
 * @author: Huang Zhiwei
 * @time: 2023/9/9 14:53
 */
public class kdxf01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] ints = new int[n];
        for(int i =0;i<n;i++){
            ints[i] = in.nextInt();
        }
        Arrays.sort(ints);
        int former = ints[0];
        if(b>a){
            for(int i =0;i<n-a;i+=a){
                if(ints[i+a] == former){
                    System.out.println(former);
                    break;
                }else {
                    former = ints[i+a];
                }
            }
        }else {
            for(int i =0;i<n-a;i+=a){
                if(ints[i+b] != former){
                    System.out.println(former);
                    break;
                }else {
                    former = ints[i+a];
                }
            }
        }
    }
}
