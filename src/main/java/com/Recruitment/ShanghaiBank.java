package com.Recruitment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 上海银行
 * @author: Huang Zhiwei
 * @time: 2023/9/17 19:01
 */
public class ShanghaiBank {
    public static void main(String[] args) {

        threenum(4,0);
    }
    public static String reverse(String s){
        String s2 = "";
        for(int i =0;i<s.length()-1;i++){
            s2 = s.charAt(i) + s2;
        }
        return s2;
    }
    public static void threenum(int m,int n){
        if(m - n < 3){
            System.out.println("none");
        }
        int[] ints = new int[m-n];
        for(int i = 0;i<m-n;i++){
            ints[i] = n+i;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0;i<ints.length;i++){
            if(ints[i] == 0){
                continue;
            }
            ArrayList<Integer> answer = helper(ints,i);
            for(int a :answer){
                arrayList.add(a+ints[i]*100);
            }
        }
        System.out.println(Arrays.toString(arrayList.toArray()));
    }
    public static ArrayList<Integer> helper(int[] ints, int start){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0;i < start;i++){
            int[] answer = helper2(ints,ints[start],ints[i]);
            for(int p:answer){
                arrayList.add(ints[i]*10+p);
            }
        }
        for(int i = start+1;i < ints.length;i++){
            int[] answer = helper2(ints,ints[start],ints[i]);
            for(int p:answer){
                arrayList.add(ints[i]*10+p);
            }
        }
        return arrayList;
    }
    public static int[] helper2(int[] ints,int usedA,int usedB){
        int[] answer = new int[ints.length-2];
        int index = 0;
        for(int i:ints){
            if(i == usedA || i == usedB){
                continue;
            }else {
                answer[index++] = i;
            }
        }
        return answer;
    }
}
