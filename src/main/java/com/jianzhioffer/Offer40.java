package com.jianzhioffer;

import java.util.PriorityQueue;

/**
 * @description: 最小的k个数
 * 首先想到的是维护一个小顶堆，使用优先级队列即可，此方法的空间复杂度较大，因为需要申请大量额外空间
 * 也可以取巧，直接使用排序后的数组
 * @author: Huang Zhiwei
 * @time: 2023/5/2 13:48
 */
public class Offer40 {
    public static void main(String[] args) {
        String A = "abc";
        String B = "abc";
        System.out.println(A == B);
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int x:arr){
            queue.add(x);
        }
        int[] ans = new int[k];
        for(int i = 0;i<k;i++){
            ans[i] = queue.poll();
        }
        return ans;
    }
}
