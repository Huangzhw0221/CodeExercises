package com.Recruitment;

import java.util.Scanner;

/**
 * @description: 荣耀
 * 求平方根
 * @author: Huang Zhiwei
 * @time: 2023/9/10 18:06
 */
public class rongyao01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int result = sqrt(N);
        System.out.println(result);
    }
    public static int sqrt(int x){
        double low =0;
        double high =x;
        double wucha = 0.00001;
        while (high -low>wucha){
            double mid = (low+high)/2;
            double square = mid*mid;
            if(square == x){
                return (int)mid;
            }else if(square <x){
                low = mid;
            }else {
                high = mid;
            }
        }
        return (int) (low+high)/2;
    }
}
