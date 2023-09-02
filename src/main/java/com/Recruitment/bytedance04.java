package com.Recruitment;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/8/27 11:20
 */
public class bytedance04 {
    public static void main(String[] args) {
        int sumOfMaxDigits = calculateSumOfMaxDigits(1, 101);
        System.out.println("Sum of Max Digits: " + sumOfMaxDigits);
    }

    public static int calculateMaxDigit(int num) {
        int maxDigit = 0;
        while (num > 0) {
            int digit = num % 10;
            maxDigit = Math.max(maxDigit, digit);
            num /= 10;
        }
        return maxDigit;
    }

    public static int calculateSumOfMaxDigits(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += calculateMaxDigit(i);
        }
        return sum;
    }
}

