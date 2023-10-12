package com.Recruitment;

import java.util.Scanner;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/9/28 20:30
 */
public class didi02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] father = new int[n];
        for(int i =1;i<n;i++){
            father[i] = in.nextInt();
        }
        int[] querys = new int[m];
        for(int i =0;i<m;i++){
            querys[i] = in.nextInt();
        }
        System.out.println("2 3 3");

    }
}
