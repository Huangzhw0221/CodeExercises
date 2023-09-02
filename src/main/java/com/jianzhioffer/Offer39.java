package com.jianzhioffer;

/**
 * @description: 数组中出现次数超过一半的数字
 * 由于一定存在多数元素，用两军交战的思想，哪边人数多就是哪边胜出；
 * 用一个计数器保存一方的数量，如果数量为0，那么下一个进入的元素就会夺得target，只需要一次遍历即可找出多数元素，且消耗较小
 * @author: Huang Zhiwei
 * @time: 2023/5/2 13:38
 */
public class Offer39 {
    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(inputs));
    }
    public static int majorityElement(int[] nums) {
        //计数器
        int count = 0;
        //相当于军旗，标志
        int target = nums[0];
        for(int item:nums){
            if(count == 0){
                target = item;
            }
            if(item == target){
                count +=1;
            }else{
                count -=1;
            }
        }
        return target;
    }
}
