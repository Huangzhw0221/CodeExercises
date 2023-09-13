package com.Recruitment;

import java.util.Scanner;

/**
 * 1. @ClassDescription:米哈游
 *网格问题，在网格中，上下是连通的，左右也是连通的，给出了三个坐标，计算a-b-c的最少步数
 *纯数学问题，计算差值即可
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年08月13日21:05
 */
public class mhy01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int xMax = in.nextInt();
        int yMax = in.nextInt();
        int[] A = new int[2];
        int[] B = new int[2];
        int[] C = new int[2];
        A[0] = in.nextInt();
        A[1] = in.nextInt();
        B[0] = in.nextInt();
        B[1] = in.nextInt();
        C[0] = in.nextInt();
        C[1] = in.nextInt();
        int step =minStep(A,B,xMax,yMax)+minStep(B,C,xMax,yMax);
        System.out.println(step);

    }
    public static int minStep(int[] a,int[] b,int xMax,int yMax){
//分别计算x方向上的步数和y方向的步数

        int atob = Math.abs(a[0] - b[0]);
        int atransb = Math.min(a[0],b[0])+xMax-Math.max(a[0],b[0]);
        int xstep = Math.min(atob,atransb);

        int atoby = Math.abs(a[1] - b[1]);
        int atransby = Math.min(a[1],b[1])+yMax-Math.max(a[1],b[1]);
        int ystep = Math.min(atoby,atransby);
        return xstep+ystep;
    }
}

