package com.jianzhioffer;

/**
 * @description: 圆圈中最后剩下的数字
 * 基本约瑟夫环问题，由于不能使用链表，用数组模拟这个队列；用到了数学解法，看看就好了，一般出现的问题都是这个的变体
 * @author: Huang Zhiwei
 * @time: 2023/5/2 16:56
 */
public class Offer62 {
    public static void main(String[] args) {

    }
    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }
}
