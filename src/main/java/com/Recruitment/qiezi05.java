package com.Recruitment;

import java.util.Scanner;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/8/30 19:54
 */
public class qiezi05 {
    public static int countOccurrences(String a, String b) {
        int count = 0;
        int[] next = computeNext(a);

        int i = 0, j = 0;
        while (i < b.length()) {
            if (a.charAt(j) == b.charAt(i)) {
                i++;
                j++;
                if (j == a.length()) {
                    count++;
                    j = next[j];
                }
            } else if (j > 0) {
                j = next[j];
            } else {
                i++;
            }
        }

        return count;
    }

    private static int[] computeNext(String a) {
        int[] next = new int[a.length() + 1];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < a.length()) {
            if (j == -1 || a.charAt(i) == a.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();

        String str = in.next();
        int sum = 0;
        for (int i = 0; i < m; i++) sum += countOccurrences(in.next(), str);
        System.out.println(sum);
    }
}
