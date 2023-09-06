package com.CodeCaprice.Greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @description: K次取反后最大化的数组和
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * 以这种方式修改数组后，返回数组可能的最大和。
 *
 * 使用贪心的思路，在遍历的时候先让绝对值最大的负数变为正数，如果所有数字都是正数了，就让绝对值最小的正数变为负数。
 * 下面的方法A写的比较混乱；
 * 下面的方法B写的是代码随想录的版本；
 * @author: Huang Zhiwei
 * @time: 2023/9/4 11:19
 */
public class Greedy07LargestSumAfterKNegations {
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,-3};
        System.out.println(largestSumAfterKNegationsB(nums,4));
    }
    public static int largestSumAfterKNegationsA(int[] nums, int k) {
        // 排序，让负数排在前面
        Arrays.sort(nums);
        int index = 0;
        while (k>0){
            k--;
            if(index<nums.length && nums[index] < 0){
                nums[index] = -nums[index];
                index++;
            }else {
                // 这里表示原本是负数的部分结束了，需要考虑全部是负数的情况还是全部是正数的情况
                // 先处理全是负数的情况：直接对最后一个数字操作
                if(index == nums.length){
                    int minNum = nums[nums.length-1];
                    nums[nums.length-1] = k%2 == 1 ? minNum:-minNum;
                    break;
                }
                if((index > 1)){
                    index --;
                }
                // 找到绝对值最小的数字
                if(Math.abs(nums[index])>Math.abs(nums[index+1])){
                    int minNum = nums[index+1];
                    nums[index+1] = k%2 == 1 ? minNum:-minNum;
                }else {
                    int minNum = nums[index];
                    nums[index] = k%2 == 1 ? minNum:-minNum;
                }
                break;
            }
        }
        int sum = Arrays.stream(nums).sum();
        return sum;
    }
    public static int largestSumAfterKNegationsB(int[] nums, int K) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完
        if (K % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();
    }
}
