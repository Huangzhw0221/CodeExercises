package com.CodeCaprice.Sort;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author: Huang Zhiwei
 * @time: 2023/9/9 17:13
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,7,4,6};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
    public static int[] bubbleSort(int[] arr){
        for(int i = 1;i<arr.length;i++){
            for(int j = 0;j<arr.length-i;j++){
                // 冒泡
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }
    public static void swap(int[] arr, int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static int[] bubbleSortA(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // Change flag
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

}
