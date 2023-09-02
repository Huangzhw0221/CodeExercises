package com.jianzhioffer;

/**
 * @description: 不用加减乘除做加法
 * 位运算，没啥意思，自己写肯定还是很捞的写法
 * @author: Huang Zhiwei
 * @time: 2023/5/2 17:23
 */
public class Offer65 {
    public int add(int a, int b) {
        while (b != 0) {
            //进位
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
