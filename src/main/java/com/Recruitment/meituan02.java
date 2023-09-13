package com.Recruitment;


import java.util.Scanner;

/**
 * 1. @ClassDescription:美团
 *蛋糕切分问题，题目具体是啥忘记了
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年08月12日10:36
 */
public class meituan02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] cake = new int[row][col];
        int temp;
        int total = 0;
        for(int i =0;i<row;i++){
            for(int j = 0;j<col;j++){
                temp = in.nextInt();
                cake[i][j] = temp;
                total += temp;
            }
        }
        int minAbsDiff = Integer.MAX_VALUE;
//按照行切开，那么就是按行求和
//需要保留已经累加的行
        int sumA = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                sumA += cake[i][j];
            }
            int sumB = total - sumA;
            int diff = Math.abs(sumA-sumB);
            minAbsDiff = Math.min(minAbsDiff,diff);
        }
//再按列切
        sumA = 0;
        for(int j = 0;j<col;j++){
            for(int i = 0;i<row;i++){
                sumA += cake[i][j];
            }
            int sumB = total - sumA;
            int diff = Math.abs(sumA-sumB);
            minAbsDiff = Math.min(minAbsDiff,diff);
        }
        System.out.println(minAbsDiff);
    }
}

