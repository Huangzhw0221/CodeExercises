package com.CodeCaprice.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 用最少数量的箭引爆气球
 * 重叠区间问题，依然使用排序，假设按照起始位置排序，那么就在重叠区间的最右边界射出一支箭。
 * 按照这个思路局部最优就是一支箭射穿最多的重叠气球，全局最优就是用最少的箭完成任务。
 * @author: Huang Zhiwei
 * @time: 2023/9/18 10:43
 */
public class Greedy12FindMinArrowShots {
    public static void main(String[] args) {
        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println(findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int count = 1;

        for(int i=1;i<points.length;i++){
            if (points[i][0] > points[i - 1][1]) {  // 气球i和气球i-1不挨着，注意这里不是>=
                count++; // 需要一支箭
            } else {  // 气球i和气球i-1挨着
                points[i][1] = Math.min(points[i][1], points[i - 1][1]); // 更新重叠气球最小右边界
            }
        }

        return count;
    }
}
