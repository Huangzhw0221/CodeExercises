package com.jianzhioffer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @description: 和为s的两个数字
 * 经典两数之和问题，使用哈希表，遍历一次即可
 * @author: Huang Zhiwei
 * @time: 2023/5/2 15:50
 */
public class Offer57_1 {
    public static void main(String[] args) {
        int[] inputs = {10,26,30,31,47,60};
        System.out.println(Arrays.toString(twoSum(inputs, 40)));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for(int x:nums){
            if(set.contains(x)){
                return new int[]{x,target-x};
            }else {
                set.add(target-x);
            }
        }
        return null;
    }
}
