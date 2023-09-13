package com.Recruitment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 1. @ClassDescription:小米
 *计算串行执行任务的最低要求的电量
 *总是不能ac，思路是先按照电量需求升序，消耗降序 排序
 *然后逐个计算是否满足，相当于是贪心
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年09月02日17:04
 */
public class xiaomi02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String cost_ele = in.next();
//切分电量和消耗
        String[] tempcost = cost_ele.split(",");
        int[][] costs = new int[tempcost.length][2];
        int count = 0;
//构造消耗-电量数组
        for(String s:tempcost){
            costs[count][0] = Integer.parseInt(s.split(":")[0]);
            costs[count][1] = Integer.parseInt(s.split(":")[1]);
            count++;
        }
//按照电量需求升序排序
//        Arrays.sort(costs, Comparator.comparingInt(arr->arr[1]));
        //按照电量需求降、消耗降序
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]){
                    return o2[1]-o1[1];
                }else {
                    return o2[0]-o1[0];
                }
            }
        });
        for(int[] row :costs){
            System.out.println(Arrays.toString(row));
        }
        int currentPower = costs[0][1];
        int minPower = costs[0][1];
        for(int i = 1;i<costs.length;i++){
            int requiredPower = costs[i][1];
            int costPower = costs[i][0];
//如果当前电量小于需要的电量，计算差值
            if(currentPower < requiredPower){
                int additionalPower =  requiredPower - currentPower;
                minPower += additionalPower;
                currentPower += additionalPower;
            }
//执行任务，减去一些电
            currentPower -= costPower;
        }
        if (minPower > 4800) {
            System.out.println(-1);
        }else {
            System.out.println(minPower);
        }
    }
}

