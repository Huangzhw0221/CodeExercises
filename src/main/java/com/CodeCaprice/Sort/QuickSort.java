package com.CodeCaprice.Sort;

import java.util.Arrays;

/**
 * @description: 快排
 * 选基数
 * 比基数小的放左边、比基数大的放右边，使用partition函数返回这个分界线，然后递归
 *
 * @author: Huang Zhiwei
 * @time: 2023/9/9 17:22
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {72, 73, 71, 23, 94, 16, 5};
        quickSortA(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSortA(int[] array,int low,int high){
        if(low <high){
            // 返回中间值
            int position = partitionA(array,low,high);
            quickSortA(array,low,position-1);
            quickSortA(array,position+1,high);
        }
    }
    public static int partitionA(int[] array ,int low,int high){
        int base = array[high];
        int pointer = low;
        for(int i = low;i<high;i++){
            // 小于base放左边
            if(array[i] < base){
                swap(array,i,pointer);
                pointer++;
            }
        }
        swap(array,high,pointer);
        return pointer;
    }
    public static void swap(int[] arr, int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int pointer = low;
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
            System.out.println(Arrays.toString(array));
        }
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int position = partition(array, low, high);
            quickSort(array, low, position - 1);
            quickSort(array, position + 1, high);
        }
    }

}