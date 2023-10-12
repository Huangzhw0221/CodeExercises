package com.Recruitment;

import java.util.Scanner;

/**
 * @description: 满帮04
 * 字符串问题
 * @author: Huang Zhiwei
 * @time: 2023/9/24 15:13
 */
public class manbang04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        String[] strings = new String[count];
        for(int i =0;i<count;i++){
            strings[i] = in.next();
        }

    }
//    public static boolean helper(String s){
//        char[] chars = s.toCharArray();
//        char former = chars[0];
//        int count = 1;
//        boolean upOrDown = true;
//        boolean ifskip = false;
//        for(char c :chars){
//            if(c - '0' >= 0 && c-'9' <=0 && !ifskip){
//                if(count == 0){
//                    former = c;
//                    count++;
//                    continue;
//                }
//                if(c - former == 1 && upOrDown){
//                    count++;
//                }else if(c -former == -1 && !upOrDown){
//                    count++;
//                }else {
//                    count = 0;
//                    ifskip = true;
//                }
//            }else if(c-'9' >0){
//                ifskip = false;
//            }
//        }
//        return count >=3 ?
//    }
}
