package com.Recruitment;

/**
 * @description: 字节跳动笔试题
 * @author: Huang Zhiwei
 * @time: 2023/8/27 10:05
 */
public class bytedance {
    public static void main(String[] args) {
        String s = "abc";
        String t = "abba";

        int maxSimilarity = calculateMaxSimilarity(s, t);
        System.out.println("Maximum Similarity: " + maxSimilarity);
    }

    public static int calculateMaxSimilarity(String s, String t) {
        int maxSimilarity = 0;

        // Calculate the initial similarity
        int a = 0;
        int b = 0;
        while (a < s.length() && a < t.length() && s.charAt(a) == t.charAt(a)) {
            a++;
        }
        while (b < s.length() - a && b < t.length() - a && s.charAt(s.length() - 1 - b) == t.charAt(t.length() - 1 - b)) {
            b++;
        }
        maxSimilarity = a * b;

        for (int i = 0; i < s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != s.charAt(i)) {
                    StringBuilder modifiedS = new StringBuilder(s);
                    modifiedS.setCharAt(i, c);
                    int newSimilarity = calculateSimilarity(modifiedS.toString(), t);
                    maxSimilarity = Math.max(maxSimilarity, newSimilarity);
                }
            }
        }

        return maxSimilarity;
    }

    public static int calculateSimilarity(String s, String t) {
        int a = 0;
        int b = 0;
        while (a < s.length() && a < t.length() && s.charAt(a) == t.charAt(a)) {
            a++;
        }
        while (b < s.length() - a && b < t.length() - a && s.charAt(s.length() - 1 - b) == t.charAt(t.length() - 1 - b)) {
            b++;
        }
        return a * b;
    }
}

