package com.jianzhioffer;

/**
 * @description: 数字序列中某一位的数字
 * 分段问题，从位数较低的地方开始看起：
 * 0-9：即第0-9位，直接返回
 * 10-99：即第10-（10+90*2）=189
 * 100-999：即第190-（190+3*900）=2890
 * 那么可以总结一个规律：位数占用会逐步增长：1*9，2*90，3*99，4*999.。。。。。
 * 根据查询的位数可以知道属于那个位数区间
 * @author: Huang Zhiwei
 * @time: 2023/5/2 19:41
 */
public class Offer44 {
    public int findNthDigit(int n) {
        //d表示位数，count表示当前位数的数占据了多少位数
        int d = 1, count = 9;
        while (n > (long) d * count) {
            //从第一位算起
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }
}
