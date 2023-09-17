package com.Recruitment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description: 富图01
 * 递归求解一条路径上的最大的节点权重值。要求找到一条超过m的路径（一旦超过m就停下），在这条路径上找出权值最大的节点。
 * @author: Huang Zhiwei
 * @time: 2023/9/16 14:45
 */
public class futu01 {
    static ArrayList<Integer[]> childs = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        long[] value = new long[n];
        for(int i = 0;i<n;i++){
            value[i] = in.nextLong();
        }
        for(int i = 0;i<n;i++){
            int p = in.nextInt();
            Integer[] temp = new Integer[p];
            for(int j =0;j<p;j++){
                temp[j] = in.nextInt();
            }
            childs.add(temp);
        }
        System.out.println(tempmax(m, 0, value,0,value[0]));
    }
    // m:题目要求的和 sum:当前的和 value:权值 childs:子节点表 temp:当前子节点 max:当前路径上的最大权值
    public static long tempmax(long m,int sum,long[] value,int temp,long max){
        sum += value[temp];
        if(sum >= m){
            return max;
        }
        Integer[] sons = childs.get(temp);
        if(sons.length == 0){
            return -1;
        }
        int count = 0;
        for(int p:sons){
            long u = tempmax(m,sum,value,p-1,max);
            if(u != -1){
                max = Math.max(max,u);
            }else {
                count++;
            }
        }
        if(count == sons.length){
            return -1;
        }
        return Math.max(max,value[temp]);
    }
}

//5 8
//1 2 3 4 5
//4 2 3 4 5
//0
//0
//0
//0