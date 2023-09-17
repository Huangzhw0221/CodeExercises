package com.CodeCaprice.Sort;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * @description: kmp算法
 * KMP算法需要是字符串匹配的算法，算法为字串定义一个辅助查询的前缀表temp，temp的构造法和实际查询时的构造法是一样的
 * @author: Huang Zhiwei
 * @time: 2023/9/14 15:03
 */
public class KMP {
    public static void main(String[] args) {
        String longstr = "aabaabaaxaabaabaaa";
        String sub = "aabaabaaa";
//        sub = "abcdabca";
        System.out.println(findstart(longstr,sub));
    }

    @Contract(pure = true)
    public static int @NotNull [] generateTemp(char[] str){
        int[] temp = new int[str.length];
        int i = 1;
        int j =0;
        while (i<str.length){
            if(str[i] == str[j]){
                temp[i] = temp[i-1] +1;
                i++;
                j++;
            }else{
                while(j > 0 && str[i] != str[j]){
                    j = temp[j-1];
                }
                if(str[i] == str[j]){
                    temp[i] = temp[j] + 1;
                }else {
                    temp[i] =0;
                }
                i++;
            }
        }
        return temp;
    }
    public static int findstart(String longstr, String shortstr){
        char[]  shortchar = shortstr.toCharArray();
        char[] longchar = longstr.toCharArray();
        int[] temp = generateTemp(shortchar);

        // 和前面的比较逻辑一样
        int i = 0;
        int j = 0;
        while(i < longstr.length() && j < shortstr.length()){
            if(longchar[i] == shortchar[j]){
                i++;
                j++;
            }else{
                while (j>0 && longchar[i] != shortchar[j]){
                    j = temp[j-1];
                }
                if(longchar[i] == shortchar[j]){
                    i++;
                    j++;
                }else {
                    i++;
                    j =0;
                }
            }
        }
        return i - shortchar.length;
    }

}
