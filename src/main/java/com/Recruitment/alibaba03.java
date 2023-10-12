package com.Recruitment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/9/23 20:25
 */
public class alibaba03 {
    public static void main(String[] args) {
        solution2();
//        Scanner in = new Scanner(System.in);
//        int count = in.nextInt();
//        int[] ints = new int[count];
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i = 0;i<count;i++){
//            int temp = in.nextInt();
//            ints[i] = temp;
//            if(map.containsKey(temp)){
//                map.put(temp,map.get(temp)+1);
//            }else {
//                map.put(temp,1);
//            }
//        }
//        Arrays.sort(ints);
//        int result = 0;
//        for(int i = 0;i<ints.length-2;i++){
//            for(int j = ints.length-2;j>i;j--){
//                // 如果是倍数，寻找下一个数
//                if(ints[j] % ints[i] == 0){
//                    for(int k = ints.length-1;k>j;k--){
//                        if(ints[k] % ints[j] == 0 && map.get(ints[i]) >0 && map.get(ints[j]) >0 && map.get(ints[k]) >0){
//                            result++;
//                            map.put(ints[i],map.get(ints[i])-1);
//                            map.put(ints[j],map.get(ints[j])-1);
//                            map.put(ints[k],map.get(ints[k])-1);
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(result);
    }
    public static void solution2(){
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<count;i++){
            int temp = in.nextInt();
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }else {
                map.put(temp,1);
            }
        }
        // 136 126 124 111
        int count1 = Math.min(map.get(3),map.get(6));
        count1 = Math.min(map.get(1),count1);
        map.put(1,map.get(1)-count1);
        map.put(3,map.get(3)-count1);
        map.put(6,map.get(6)-count1);

        int count2 = Math.min(map.get(2),map.get(6));
        count2 = Math.min(map.get(1),count2);
        map.put(1,map.get(1)-count2);
        map.put(2,map.get(2)-count2);
        map.put(6,map.get(6)-count2);

        int count3 = Math.min(map.get(2),map.get(4));
        count3 = Math.min(map.get(1),count3);
        map.put(1,map.get(1)-count3);
        map.put(2,map.get(2)-count3);
        map.put(4,map.get(4)-count3);

        int count4 = map.get(1)/3;
        System.out.println(count1+count2+count3+count4);
//        Arrays.sort(ints);
//        int result = 0;
//        for(int i = 0;i<ints.length-2;i++){
//            for(int j = ints.length-2;j>i;j--){
//                // 如果是倍数，寻找下一个数
//                if(ints[j] % ints[i] == 0){
//                    for(int k = ints.length-1;k>j;k--){
//                        if(ints[k] % ints[j] == 0 && map.get(ints[i]) >0 && map.get(ints[j]) >0 && map.get(ints[k]) >0){
//                            result++;
//                            map.put(ints[i],map.get(ints[i])-1);
//                            map.put(ints[j],map.get(ints[j])-1);
//                            map.put(ints[k],map.get(ints[k])-1);
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(result);
    }
}
