package com.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 和为s的连续正数序列
 * 暴力法，终止条件是i<=target/2和j<=target/2+1；其中类型转换是一个比较麻烦的问题
 * @author: Huang Zhiwei
 * @time: 2023/5/2 15:58
 */
public class Offer57_2 {
    public static void main(String[] args) {
        int[] inputs = {10,26,30,31,47,60};
        System.out.println(Arrays.toString(findContinuousSequence(9)));
    }
    public static int[][] findContinuousSequence(int target) {
        List<Integer[]> ans = new ArrayList<>();
        int sum = 0;
        for(int i = 1;i<=target/2;i++){
            sum = i;
            for(int j = i+1;j<=target/2+1;j++){
                sum+=j;
                if(sum == target){
                    Integer[] innerans = new Integer[j-i+1];
                    for(int u = 0;u<innerans.length;u++){
                        innerans[u] = i+u;
                    }
                    ans.add(innerans);
                }else if(sum > target){
                    break;
                }
            }
        }
        int[][] re = new int[ans.size()][];
        int z= 0;
        for(Integer[] x:ans){
            re[z++] = Arrays.stream(x).mapToInt(Integer::valueOf).toArray();
        }
        return re;
    }
}
