package com.Recruitment;

import java.util.Scanner;

/**
 * @description: 茄子科技01
 * 给定一个3的任意倍数的正整数n，输出把这个正整数n分解为三个3的倍数的方法数。
 * 注意，如果分解数字的顺序不 同，则考虑不同为方法。例如，12=3+6+3 和12= 3 +3 + 6是不同的方法。
 * 数字： 9 12 15 18 21
 * 拆分： 1 3  6  10 15
 * @author: Huang Zhiwei
 * @time: 2023/8/30 19:26
 */
public class qiezi03 {

    public static int splitNumber(int n) {
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                int k = n - i - j;
                if (k != 0 && i + j + k == n) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for(int i = 0 ;i<c;i++){
            System.out.println(splitNumber(in.nextInt()/3));
        }
    }
}

