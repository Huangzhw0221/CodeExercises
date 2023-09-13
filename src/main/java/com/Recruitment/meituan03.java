package com.Recruitment;

import java.util.Scanner;

/**
 * 1. @ClassDescription:美团
 *忘记了题目
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年08月12日10:59
 */
public class meituan03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        char[] chars = new char[count];
        String input = in.next();
        for(int i = 0;i<count;i++){
            chars[i] = input.charAt(i);
        }
        if(count == 1){
            System.out.println(1);
            return;
        }
        int minQuanzhi = Integer.MAX_VALUE;
        int quan = 0;
//先看1行这种特殊情况
        for(int i = 0;i<count-1;i++){
            if(chars[i] != chars[i+1]){
                quan += 1;
            }
        }
        minQuanzhi = Math.min(minQuanzhi,quan);
//再看多行的情况
        for(int i = 1;i<count/2 +1;i++){
            if(count % i == 0){
//先构造符合条件的矩阵
                char[][] tempChar =generateChar(chars,i,count/i);
//再送入计算
                quan =caculate(tempChar);
                minQuanzhi = Math.min(minQuanzhi,quan);
            }
        }
        System.out.println(minQuanzhi);
    }
    public static int caculate(char[][] chars){
        int rows = chars.length;
        int cols = chars[0].length;
        boolean[][] isused = new boolean[rows][cols];
        int weight = 0;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if (!isused[i][j]){
                    dfs(chars,isused,i,j);
                    weight++;
                }
            }
        }
        return weight;
    }
    public static void dfs(char[][] chars,boolean[][] booleans,int row,int col){
        int rows = chars.length;
        int cols = chars[0].length;
        if(row <0 ||row >= rows || col<0 ||col >=cols){
            return;
        }
        char currentChar = chars[row][col];
        booleans[row][col] = true;

        int[] heng = {-1,1,0,0};
        int[] shu = {0,0,-1,1};

        for(int i = 0;i<4;i++){
            int newRow = row+heng[i];
            int newCol = col+shu[i];
            if(newRow >= 0 && newRow<rows && newCol>=0 && newCol < cols && !booleans[newRow][newCol]
                    && chars[newRow][newCol] == currentChar){
                dfs(chars,booleans,newRow,newCol);
            }
        }
    }
    public static char[][] generateChar(char[] chars,int row,int col){
        char[][] result = new char[row][col];
        int count = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                result[i][j] = chars[count++];
            }
        }
        return result;
    }

}

