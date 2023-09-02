package com.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/4/19 10:08
 */
public class huawei01 {
    static int cnt;
    static List<Integer> R = new ArrayList<>();

    public static boolean check(int x) {
        int res = 0;
        for (int r : R) {
            if (r <= x) res += r;
            else res += x;
        }
        return res <= cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        for (String s : input) R.add(Integer.parseInt(s));
        cnt = sc.nextInt();

        int l = 0, r = (int) 1e5;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }

        System.out.println(r);
    }
}
