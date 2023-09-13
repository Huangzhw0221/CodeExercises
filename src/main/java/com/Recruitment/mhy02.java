package com.Recruitment;


import java.util.*;

/**
 * 1. @ClassDescription:米哈游
 *忘记了
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年08月13日21:24
 */
public class mhy02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt()-1;
        int k = in.nextInt();
        int[][] edges = new int[count][2];
        for(int i = 0;i<count;i++){
            edges[i][0] = in.nextInt();
            edges[i][1] = in.nextInt();
        }
        in.close();
//构造每一层
        List<Integer> level1 = new ArrayList<>();
        level1.add(1);
        List<List<Integer>> allnodes =generateAllLevels(k+1,level1,edges);
        int total = 0;
        for(List<Integer> item:allnodes){
            total+=item.size();
        }
        System.out.println(total);

    }
    public static List<List<Integer>> generateAllLevels(int k,List<Integer> firstLevel,int[][] edges){
        List<List<Integer>> result = new ArrayList<>();
        result.add(firstLevel);
        for(int i = 1;i<k;i++){
            List<Integer> formerLevel = result.get(i-1);
            if(formerLevel.size() == 0){
                break;
            }
            result.add(generateLevels(formerLevel,edges));
        }
        return result;
    }
    public static List<Integer> generateLevels(List<Integer> formerLevel,int[][] edges){
        List<Integer> nextLevel = new ArrayList<>();
        for(Integer value:formerLevel){
            if(value == -1){
                nextLevel.add(-1);
                continue;
            }
            boolean isNode = false;
            for(int i = 0;i<edges.length;i++){
                if(edges[i][0] == value){
                    nextLevel.add(edges[i][1]);
                    isNode = true;
                }
            }
            if(!isNode){
                nextLevel.add(-1);
            }
        }
        return nextLevel;
    }
}

