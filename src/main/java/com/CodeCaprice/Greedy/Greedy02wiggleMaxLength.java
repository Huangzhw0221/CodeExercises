package com.CodeCaprice.Greedy;

/**
 * @description: 摆动序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
 * 第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。输出这个摆动序列的长度。
 *
 * 思路：局部最优就是删除单调坡上的元素，全局最优就是最长的摆动序列。题目中只需要求摆动的长度，而不需要真的把元素删除。下面列出几种特殊情况：
 * 1、对于上下坡有平坡的情况，我们需要规定删去左边的节点还是右边的节点，例如1-2-2-2-1中我们规定删除前面的2。
 * 2、对于首尾元素处理，例如1-2，它的摆动应当为2，那么我们将最左边添加一个1，形成1-1-2；最右边则默认参与计数。
 * @author: Huang Zhiwei
 * @time: 2023/9/2 21:16
 */
public class Greedy02wiggleMaxLength {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,2,3,5,1};
        System.out.println(wiggleMaxLength(nums));
    }
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length == 1)return 1;
        int prediff = 0;
        int curdiff = 0;
        int result = 1;
        for(int i = 0;i<nums.length-1;i++){
            curdiff = nums[i+1] -nums[i];
            if((prediff >= 0 && curdiff <0)|| (prediff <=0 && curdiff >0)){
                result ++;
                prediff = curdiff;
            }
        }
        return result;
    }
}
