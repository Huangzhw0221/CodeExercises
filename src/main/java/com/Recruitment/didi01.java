package com.Recruitment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @description: 滴滴01 砍圆木凑三角形
 * @author: Huang Zhiwei
 * @time: 2023/9/28 19:49
 */
public class didi01 {
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ints = new int[3];
        for(int i =0;i<3;i++){
            ints[i] = in.nextInt();
        }
        int count = 0;
        if(isTraiangle(ints) == 1){
            count = 1;
        }
        System.out.println(helper(ints,1,count,n));
    }
    public static int helper(int[] arr,int minus,int count,int max){
        if(minus > max){
            return count;
        }
        int[] tempA = arr.clone();
        int[] tempB = arr.clone();
        int[] tempC = arr.clone();
        tempA[0] -= minus;
        tempB[1] -= minus;
        tempC[2] -= minus;
        if(isTraiangle(tempA) > -1){
            if(isTraiangle(tempA) ==1){
//                count = addTemp(tempA) ? count+1 :count;
                count++;
            }
            count = helper(tempA,minus+1,count,max);
        }
        if(isTraiangle(tempB) >-1){
            if(isTraiangle(tempB) ==1){
//                count = addTemp(tempB) ? count+1 :count;
                count++;
            }
            count = helper(tempB,minus+1,count,max);
        }
        if(isTraiangle(tempC) >-1){
            if(isTraiangle(tempC) ==1){
//                count = addTemp(tempC) ? count+1 :count;
                count++;
            }
            count = helper(tempC,minus+1,count,max);
        }
        return count;
    }
    public static int isTraiangle(int[] arr){
        if(arr[0] <=0 || arr[1] <= 0 || arr[2] <=0){
            return -1;
        }
        if(arr[0] + arr[1] > arr[2] && arr[1] + arr[2] > arr[0] && arr[0] + arr[2] > arr[1]){
            return 1;
        }else {
            return 0;
        }
    }
    public static boolean addTemp(int[] arr){
        Arrays.sort(arr);
        int p = arr[0]*1000000 + arr[1] * 1000 + arr[2];
        if(set.contains(p)){
            return false;
        }else {
            set.add(p);
            return true;
        }
    }
}
