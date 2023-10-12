package com.Recruitment;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description: 中金所01
 *
 * @author: Huang Zhiwei
 * @time: 2023/9/22 19:22
 */
public class zhongjinsuo01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        ArrayList<Integer> ints = new ArrayList<>();

        while ( (p / 26.0) > 1.0){
            ints.add(0, p % 26 );
            p -= p % 26;
            p = p/26;
        }
        ints.add(0,p);
        for(int temp : ints){
            System.out.print((char) ('a'+temp-1));
        }
    }
}
