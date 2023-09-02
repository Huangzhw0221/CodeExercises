package com.Recruitment;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/8/13 20:26
 */
public class kmp {
    public static int[] computeNextArray(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < pattern.length() - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static int kmpSearch(String text, String pattern) {
        int[] next = computeNextArray(pattern);
        int i = 0, j = 0;

        while (i < text.length() && j < pattern.length()) {
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == pattern.length()) {
            return i - j; // Match found, return starting index of match
        } else {
            return -1; // No match found
        }
    }

    public static void main(String[] args) {
        String text = "abcababcabc";
        String pattern = "abcabc";

        int result = kmpSearch(text, pattern);
        if (result != -1) {
            System.out.println("Pattern found at index " + result);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }
}

