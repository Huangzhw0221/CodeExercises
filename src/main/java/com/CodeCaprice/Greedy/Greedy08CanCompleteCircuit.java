package com.CodeCaprice.Greedy;

/**
 * @description: 加油站问题
 *思路：做差计算该加油站是对总油量增加还是减少的，用一个变量totalSum做累加求和，
 * 如果走完一遍发现totalSum小于0，那么就不能走完一圈；
 * 再用一个变量currentSum计数当前的油量，如果当前的油量小于0，就说明起始位置不对。
 * 题目保证了仅有一个解，所以可以放心使用贪心。
 * @author: Huang Zhiwei
 * @time: 2023/9/14 14:46
 */
public class Greedy08CanCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] contribution = new int[gas.length];
        int totalSum = 0;
        int currentSum = 0;
        int start = 0;
        for(int i =0;i<gas.length;i++){
            contribution[i] = gas[i] - cost[i];
            currentSum += contribution[i];
            totalSum += contribution[i];
            if(currentSum <0){
                start = i+1;
                currentSum =0;
            }
        }
        if(totalSum <0){
            return -1;
        }
        return start;
    }
}
