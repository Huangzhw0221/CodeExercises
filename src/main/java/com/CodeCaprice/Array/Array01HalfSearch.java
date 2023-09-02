package com.CodeCaprice.Array;

/**
 * @description: 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 二分法的思想就是要分清楚左右区间的开闭情况，其他都是很容易的
 * todo 以下代码中A方法以左闭右闭来写的，B方法以做闭右开方法来写的
 * @author: Huang Zhiwei
 * @time: 2023/8/31 16:25
 */
public class Array01HalfSearch {
    public static void main(String[] args) {
        // 测试用例
        int[] arrays = new int[]{-1,0,3,5,9,12};
        System.out.println(halfSearchB(arrays, 9));
    }

    public static int halfSearchA(int[] arrays,int target){
        int left = 0,right= arrays.length -1 ;
        int middle;
        // 左闭右闭中需要考虑左右区间相等的情况，它仍然包含了一个数，所以循环应当继续
        while (left <= right){
            middle = left + (right-left)/2;
            if(arrays[middle] > target){
                right = middle -1;
            }else if(arrays[middle] <target){
                left = middle +1;
            }else {
                return middle;
            }
        }
        return -1;
    }
    public static int halfSearchB(int[] arrays,int target){
        // 左闭右开中，右边界就是length
        int left = 0,right= arrays.length ;
        int middle;
        // 左闭右开中，左右区间相等的情况不包含数，循环应当终止，所以判据应当是小于
        while (left < right){
            middle = left + (right-left)/2;
            if(arrays[middle] > target){
                // 和左闭右闭的区别在这里，如果中间的数字比target大，那么右区间的应当截止到middle
                right = middle;
            }else if(arrays[middle] <target){
                left = middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }
}
