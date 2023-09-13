package com.Recruitment;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 1. @ClassDescription:喜马拉雅
 *滑动窗口的最大值，leetcode原题
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年09月03日19:31
 */
public class xmly {
    public static void main(String[] args) {
        int[] nums = new int[]{5,3,4,2,9,6};
        int k = 3;
        System.out.println(Arrays.toString(slide(nums, k)));
    }
    /**
     *代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *滑动窗口输出最大值
     * @paramnumsint整型一维数组 输入的整数数组
     * @paramkint整型 滑动窗口大小
     * @return int整型一维数组
     */
    public static int[] slide (int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i<k;i++){
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[n-k+1];
        ans[0] = nums[deque.peekFirst()];
        for(int i =k;i<n;++i){
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i-k){
                deque.pollFirst();
            }
            ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}

