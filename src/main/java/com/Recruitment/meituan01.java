package com.Recruitment;

import java.util.Scanner;

/**
 * 1. @ClassDescription:输入分为三行，第一行输入一个数字，代表下一行输入个数，即数组长度
 *第二行输入数组，这些数字不会重复，第三行输入两个数字，这两个数字一定出现在第二中。
 *如果这两个数字是相邻的，输出Yes；如果不相邻，输出No
 *例如输入4；1 3 4 2；4 3
 *那么就要输出Yes，因为4和3是相邻的。
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年08月12日9:52
 */
public class meituan01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//先拿到排列的个数
        int count = in.nextInt();
        int[] nums = new int[count];
        for(int i =0;i<count;i++){
            nums[i] = in.nextInt();
        }
        int first = in.nextInt();
        int second = in.nextInt();

        int ans =findIndex(nums,second) -findIndex(nums,first);
        if(ans == 1 || ans == -1){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
    public static int findIndex(int[] list,int num){
        for(int i = 0;i<list.length;i++){
            if(list[i] == num){
                return i;
            }
        }
        return -1;
    }

}

