package com.CodeCaprice.Greedy;

/**
 * @description: 分发糖果
 * 思路：本题更像是使用一些技巧来解题，先从左往右遍历，如果右边的大那么就糖果数量加一，
 * 如果小于等于，那就糖果数量减一。接下来再从右往左遍历，如果左边的比右边的大，就加一，
 * 同时还需要比较当前值和从左往右遍历时的值的大小关系，取更大的那个数。最后统计数组和。
 * @author: Huang Zhiwei
 * @time: 2023/9/17 15:56
 */
public class Greedy09Candy {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(candy(nums));
    }
    public static int candy(int[] ratings) {
        int[] left2right = new int[ratings.length];
        left2right[0] = 1;
        for(int i =1;i<ratings.length;i++){
            left2right[i] = ratings[i] > ratings[i-1] ? left2right[i-1]+1:1;
        }
        int[] right2left = new int[ratings.length];
        right2left[ratings.length-1] = left2right[ratings.length-1];
        int sum = right2left[ratings.length-1];
        for(int i = ratings.length -2;i>=0;i--){
            right2left[i] = ratings[i] > ratings[i+1] ? right2left[i+1]+1 :1;
            right2left[i] = Math.max(right2left[i],left2right[i]);
            sum+= right2left[i];
        }
        return sum;
    }
}
