package com.Recruitment;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 科大讯飞
 * 这题是求一个数组的子数组，任意一个 ≥ 2的窗口中元素的均值都大于给定值，求这样一个子数组的最大长度。
 * 例如[1,9,1,9,1]的最长字串长度是4:[1,9,9,1]
 * @author: Huang Zhiwei
 * @time: 2023/9/9 15:24
 */
public class kdxf03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int m = in.nextInt();
        double[] nums = new double[count];
        double[] average = new double[count];
        int[] participate =  new int[count];
        int[] length = new int[count];
        for(int i = 0;i<count;i++){
            nums[i] = in.nextInt();
        }
        int start =0;
        for(int i =0;i<count;i++){
            if(nums[i] >= m){
               start = i;
               break;
            }
        }
        int skip = 0;
        participate[start] = 1;
        length[start] =1;
        average[start] = nums[start];
        for(int i =start+1;i<count;i++){
            double min1 = (average[i-1-skip]*participate[i-1-skip]+nums[i])/(1+participate[i-1-skip]);
            double min2 = (nums[i]+nums[i-1-skip])/2;
            double min = Math.min(min1,min2);
            average[i] = min;
            participate[i] = min1 < min2 ? participate[i-skip-1]+1:2;
            if(min < m){
                skip += 1;
            }else {
                length[i] = length[i-1-skip] + 1;
                skip =0;

            }
        }

        Arrays.sort(length);
        System.out.println(length[count-1]);
    }
}
