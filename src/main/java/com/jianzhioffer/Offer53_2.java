package com.jianzhioffer;

/**
 * @description: 0～n-1中缺失的数字
 * 二分查找法，在第i位的数字应当是等于i的，如果第i位的数字等于i-1了，说明应该去前面的区间找；反之去后面的区间找；
 * @author: Huang Zhiwei
 * @time: 2023/5/2 15:31
 */
public class Offer53_2 {
    public static void main(String[] args) {
        int[] inputs = {1};
        System.out.println(missingNumber(inputs));
    }
    public static int missingNumber(int[] nums) {
        int l = 0, h = nums.length-1, m = (l+h)/2;

        while (l <= h) {
            if (m != nums[m]) { // 缺失的数字在m位置前
                h = m-1;
            } else { // 缺失的数字在m位置后
                l = m+1;
            }
            m = (l+h)/2;
        }
        return l;
    }
}
