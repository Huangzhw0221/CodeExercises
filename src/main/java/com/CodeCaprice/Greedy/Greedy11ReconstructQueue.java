package com.CodeCaprice.Greedy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 根据身高重建队列
 * 先根据身高排序，然后从身高最高的开始插入，下标是多少，就插入多少的位置上。
 * @author: Huang Zhiwei
 * @time: 2023/9/18 10:23
 */
public class Greedy11ReconstructQueue {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }
    public static int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(people,(a,b)->{
            if(a[0] == b[0])return a[1]-b[1];
            return b[0]-a[0];
        });
        for(int[] p:people){
            list.add(p[1],p);
        }
        return list.toArray(new int[people.length][]);
    }
}
