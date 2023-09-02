package com.Recruitment;

import java.util.Scanner;

/**
 * @description: 小强有一张长度为m的敏感字词表，每个敏感字词的长度在[2,10]之间。
 * 小强现在有一个长度为n的仅有小写字母构成的字符串，希望查询其中的敏感字词个数。
 * 敏感词个数是字句内所有敏感词个数的总和，比如"owowowo"中有3个"owo"和3个"wo"，
 * 如果设定"owo""wo"为敏感词集合的话，总量就为6个。
 * @author: Huang Zhiwei
 * @time: 2023/8/30 19:41
 */
public class qiezi04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();

        String str = in.next();
        int sum = 0;
        for (int i = 0; i < m; i++) sum += countStr(str, in.next());
        System.out.println(sum);
    }

    public static int countStr(String str, String word) {
        int count = 0, index = 0;
        while (index != -1) {
            index = str.indexOf(word, index);
            if (index != -1){
                count++;
                index += 1;
            }
        }
        return count;
    }

}
