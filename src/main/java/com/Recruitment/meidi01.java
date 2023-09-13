package com.Recruitment;

import java.util.*;

/**
 * 1. @ClassDescription:美的
 *字符串处理问题，没有什么难点
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年09月06日16:20
 */
public class meidi01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        if(string.length() > 100){
            string = string.substring(0,100);
        }

        String[] strings = string.trim().split("\\s+");

//        Integer[] ints = new Integer[strings.length];
        ArrayList<Integer> ints = new ArrayList<>();
//        int index = 0;
        for(String s:strings){
            try{
                ints.add(Integer.parseInt(s));
            }catch (Exception ignored){

            }
        }
        Integer[] integers = new Integer[ints.size()];
        int index = 0;
        for(Integer s:ints){
            integers[index++] = s;
        }
        Arrays.sort(integers, Collections.reverseOrder());
        for(int i = 0;i<integers.length;i++){
            if(i == integers.length-1){
                System.out.print(integers[i]);
            }else {
                System.out.print(integers[i]+",");
            }
        }
    }

}

