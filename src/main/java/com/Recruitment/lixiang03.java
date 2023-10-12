package com.Recruitment;

import java.util.*;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/9/30 19:54
 */
public class lixiang03 {
    public static void main(String[] args) {

    }
    public ArrayList<ArrayList<Integer>> merge (ArrayList<ArrayList<Integer>> intervals) {
        // write code here
        if(intervals.size() ==0){
            ArrayList<Integer> result = new ArrayList<>();
            result.add(0);
            result.add(0);
            return new ArrayList<ArrayList<Integer>>(Collections.singleton(result));
        }
        int[][] interval = new int[intervals.size()][2];
        int index =0;
        for(ArrayList<Integer> item :intervals){
            interval[index][0] =item.get(0);
            interval[index][1] =item.get(1);
            index ++;
        }
        Arrays.sort(interval, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        ArrayList<ArrayList<Integer>> merged = new ArrayList<ArrayList<Integer>>();
        for(int i =0;i<interval.length;i++){
            int l = interval[i][0],r = interval[i][1];
            if(merged.size() == 0 || merged.get(merged.size() - 1).get(1) <l){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(l);
                temp.add(r);
                merged.add(temp);
            }else {
                merged.get(merged.size() - 1).set(1, Math.max(merged.get(merged.size() - 1).get(1), r));
            }
        }
        return merged;

    }
}
