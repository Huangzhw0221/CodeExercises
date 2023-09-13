package com.Recruitment;

import java.util.Scanner;

/**
 * @description: 榴莲分堆问题
 * 大意就是由若干堆榴莲，比如[3,7]代表3、4、5、6、7堆
 * 然后拿出两堆组合成一个需要的重量m，然后计算有几种组合方式
 *
 * 思路：找到合适的起点和终点即可
 * 如果m-r比起点小，说明要削去r（右边）如3-9 要变成3-6，9，换言之由l决定count
 * 如果m-r比起点大，说明要削去l（左边）如3-5 要变成4-5，换言之由r决定count
 * @author: Huang Zhiwei
 * @time: 2023/9/6 19:48
 */
public class dewu01 {
    public static void main(String[] args) {

        System.out.println(caculate1(3, 6, 10));
        System.out.println(caculate1(1, 2, 4));
        System.out.println(caculate1(1, 11, 12));
        System.out.println(caculate1(12345, 98765, 56789));
    }
    public static long caculate(long l,long r,long m){
        if(r+r-1 < m || l+l+1 > m){
//            System.out.println(0);
            return 0;
        }
        long count = 0;
        //削去大于m的数字
        if(r > m){
            r = m-1;
        }
        // 找到合适的起点和终点即可 以m=9为例
        // 如果m-r比起点小，说明要削去r（右边）如3-9 要变成3-6，9，换言之由l决定count
        // 如果m-r比起点大，说明要削去l（左边）如3-5 要变成4-5，换言之由r决定count
        if(m-r <=l){
            count += (((m-1)/2) - l)+1;
        }else {
            count += (r - ((m+1)/2)) +1;
        }
        return count;
    }
    public static long caculate1(long l,long r,long m){
        long lnew=0 ,rnew=0;
        if(m-r > l){
            lnew = m-r;
            rnew = r;
        }else if(m-l < r){
            lnew = l;
            rnew = m-l;
        }else {
            lnew = l;
            rnew = r;
        }
        if(lnew >= rnew){
            return 0;
        }
        return (rnew-lnew)/2 + 1;
    }
}
