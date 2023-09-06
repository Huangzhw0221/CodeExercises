package com.Recruitment;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/9/6 16:36
 */
public class meidi01 {
    public static void main(String[] args) {
        String str = " 1 2  3 4 5 ";
        String[] numbers = str.trim().split("\\s+");

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            System.out.println(num);
        }

    }
}
