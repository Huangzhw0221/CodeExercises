package com.CodeCaprice.Array;

import java.util.Arrays;

/**
 * @description: 螺旋矩阵II
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 思路1：模拟法，本题目就是纯正的模拟题，坚持左闭右开的区间定义，这样每次转圈的时候要处理的边的长度就是一样的。
 * 转圈的数量应当等于n/2，如果是奇数也没关系就最后处理中间的最后一个值。如`generateMatrixA` 方法所示。
 *
 * 思路2：模拟法（较为混乱的版本），使用究极原始的模拟法，记录每一个转向标志，剩余边的长度，
 * 如`generateMatrixB` 方法所示。
 * @author: Huang Zhiwei
 * @time: 2023/8/31 21:40
 */
public class Array05GenerateMatrix {
    public static void main(String[] args) {
        int[][] result = generateMatrixA(5);
        for(int i = 0;i<5;i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] generateMatrixA(int n) {
        //坚持左开右闭原则
        int i = 0;
        int[][] result = new int[n][n];
        int start = 1;
        while(i < n/2){
            //从左到右的横向
            for(int size = 0;size < n - 1 - 2*i;size++){
                result[i][size+i] = start++;
            }
            //从上到下的纵向
            for(int size = 0;size < n - 1 - 2*i;size++){
                result[size+i][n-1-i] = start++;
            }
            //从右到左的横向
            for(int size = 0;size < n - 1 - 2*i;size++){
                result[n-1-i][n-1-i-size] = start++;
            }
            //从下到上的纵向
            for(int size = 0;size < n - 1 - 2*i;size++){
                result[n-1-i-size][i] = start++;
            }
            i ++;
        }
        if(n % 2 == 1){
            result[n/2][n/2] = start++;
        }
        return result;
    }
    public static int[][] generateMatrixB(int n) {
        int[][] ans = new int[n][n];
        int i = 0;
        int j = 0;
        int index = 1;
        boolean upflag = false;
        boolean downflag = false;
        boolean leftflag = false;
        boolean rightflag = true;
        // 左右边界和上下边界 0,2 0,2
        int rightend = n-1;
        int leftstart = 0;
        int downend = n-1;
        int upstart = 0;

        // 转向时需要修改边界
        // 判断到头了就转向
        while(index <= n*n){
            ans[i][j] = index;
            index += 1;
            //四个方向
            if(rightflag && j<rightend){j += 1;}
            else if(leftflag && j>leftstart){j -= 1;}
            else if(downflag && i<downend){i += 1;}
            else if(upflag && i > upstart){i -= 1;}
            //转向
            else if( rightflag && j == rightend){
                rightflag = false;
                downflag = true;
                i += 1;
                upstart += 1;}
            else if( leftflag && j==leftstart){
                leftflag = false;
                upflag = true;
                i -= 1;
                downend -= 1;}
            else if(downflag && i==downend) {
                downflag = false;
                leftflag = true;
                j -= 1;
                rightend -= 1;}
            else if(upflag && i == upstart){
                upflag = false;
                rightflag = true;
                j += 1;
                leftstart += 1;}
        }
        return ans;

    }
}
