package com.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 字符串的排列
 * 和全排列一样使用回溯法，但效率非常低，其中的重大缺陷在于hashset、Stringbuilder、递归调用的巨大耗时上
 * @author: Huang Zhiwei
 * @time: 2023/5/1 20:40
 */
public class Offer38 {
    public static void main(String[] args) {
        String input = "aab";
        System.out.println(Arrays.toString(permutation(input)));
    }

    public static String[] permutation(String s) {

        if(s.length() == 1) return new String[]{s};
        HashSet<String> ans = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            String temp = String.valueOf(s.charAt(i));
            String newString = s.replaceFirst(temp,"");
            String[] thistime = permutation(newString);
            for (String item:thistime){
                StringBuilder stringBuilder = new StringBuilder(item);
                stringBuilder.append(temp);
                ans.add(stringBuilder.toString());
            }
        }
        String[] re = new String[ans.size()];
        int i = 0;
        for(String x:ans){
            re[i++] = x;
        }
        return re;
    }
}
