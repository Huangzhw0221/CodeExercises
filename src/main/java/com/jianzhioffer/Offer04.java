package com.jianzhioffer;

import java.util.HashSet;

/**
 * @description: 二维数组中的查找
 * 和12题类似使用深度优先搜索，数组越界的时候就返回false，可以借助不走回头路和比大小的特性来做，标记方式用hashset。但是这种方式超时了。
 * 暴力法：直接每个元素查一遍
 * 二分查找法：对每一行都使用一次二分查找
 * @author: Huang Zhiwei
 * @time: 2023/4/7 16:49
 */
public class Offer04 {
    public static void main(String[] args) {
//        int[][] input = {{1,4,7,11,15},
//                        {2,5,8,12,19},
//                        {3,6,9,16,22},
//                        {10,13,14,17,24},
//                        {18,21,23,26,30}};
        int[][] input = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}};
//        int[][] input = {{}};
        System.out.println(findNumberIn2DArray(input, 15));
    }
    //直接查找
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int element : row) {
                if (element == target) {
                    return true;
                }
            }
        }
        return false;
    }
//   ---------------------------------------------------------------------------------------
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length ==0 || matrix[0].length ==0||target < matrix[0][0] || target> matrix[matrix.length-1][matrix[0].length-1]){
            return false;
        }
        return dfs(matrix,target,0,0);
    }
    static HashSet<String> set = new HashSet<>();
    public static boolean dfs(int[][] matrix, int target,int i,int j){
        if(i>= matrix.length||i<0||j>=matrix[0].length||j<0|| set.contains(String.valueOf(i)+ j)) return false;
        if(matrix[i][j] == target) return true;
        //标记当前位置
        set.add(String.valueOf(i)+ j);
        //小，就往右、下找
        if(matrix[i][j] < target){
            boolean ans = dfs(matrix,target,i+1,j) || dfs(matrix,target,i,j+1);
            set.remove(String.valueOf(i)+ j);
            return ans;
        }else {
            boolean ans = dfs(matrix,target,i-1,j) || dfs(matrix,target,i,j-1);
            set.remove(String.valueOf(i)+ j);
            return ans;
        }
    }
}
