package com.Recruitment;

/**
 * 1. @ClassDescription:字符串格式化
 *就是12，13，15，16，17就用12，13，15-17表示
 *
 *纯正的字符串模拟问题，就是遍历一次，用一个计数器表示当前连续的最长子串，当碰到第一个不连续的数值时
 *就根据计数器决策往stringbuilder中写入什么内容。
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年09月10日13:24
 */
public class jili {
    public static void main(String[] args) {
        int[] ints = {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20,25};
        System.out.println(solution(ints));
    }

    public static String solution(int[] arr){
        int length = arr.length;
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int count = 0;
        int start = arr[0];
        temp.append(start);
//        temp.append(",");
        for(int i =1;i<length;i++){
            if(arr[i] ==  arr[i-1]+1){
                count+=1;
                temp.append(",");
                temp.append(arr[i]);
            }else {
                if(count >=3){
                    sb.append(",");
                    sb.append(start);
                    sb.append("-");
                    sb.append(arr[i-1]);
                    temp.setLength(0);
                    start = arr[i];

                }else {
                    sb.append(temp);
                    temp.setLength(0);
                    start = arr[i];

                }
                temp.append(",");
                temp.append(start);
                count =1;
            }
            if(i == length-1){
                if(count >=3){
                    sb.append(",");
                    sb.append(start);
                    sb.append("-");
                    sb.append(arr[i]);
                    temp.setLength(0);
                }else {
                    sb.append(temp);
                }
            }
        }
        return sb.toString();
    }
}

