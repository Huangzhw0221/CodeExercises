package com.Recruitment;

import java.util.Scanner;

/**
 * 1. @ClassDescription:广联达
 *染色问题，要求选择一个区间（区间长度是偶数），将区间内右半部分的复制到左半部分。
 * index下标小于0了说明所有都染色完毕了
 *
 *思路是从右到左染色，用一个index记录下标。如果出现和最右边的数字不一样的数，说明需要一次染色操作，染色一次那么相同色彩的长度就翻倍。
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年09月06日14:37
 */
public class guanglianda02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] nums = new int[count];
        for(int i = 0;i<count;i++){
            nums[i] =  in.nextInt();
        }
        System.out.println(color(nums));
    }
    public static int color(int[] nums){
        if(nums.length == 1){
            return 0;
        }
//从右到左染色，所以取最右边的一个
        int last = nums[nums.length-1];
        int index = nums.length-2;
//操作数
        int count = 0;
        while (index >=0){
//如果两个数是相等的，那就不用操作
            if(nums[index] == last){
                index --;
            }else {
//如果不相等就需要染色，一次性染最长的长度
                count ++ ;
                int length = nums.length-1-index;//已经一样了的长度；
                index = nums.length-1-2*length;
                if(index < 0){
                    break;
                }
            }
        }
        return count;
    }
}
