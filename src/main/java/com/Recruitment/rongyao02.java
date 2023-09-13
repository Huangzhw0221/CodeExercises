package com.Recruitment;

import java.util.*;

/**
 * @description: 荣耀
 * 买卖货物，第一行是成本，第二行是卖出的价格，第三行是本钱
 * 创建一个数组，第一列写利润，第二列写成本，第三列写是否访问
 * @author: Huang Zhiwei
 * @time: 2023/9/10 18:21
 */
public class rongyao02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String m = in.nextLine();
        if(m.isEmpty()){
            System.out.println(0);
        }
        String n = in.nextLine();
        int k = in.nextInt();
        String[] mString = m.split(",");
        String[] nString = n.split(",");
        int[][] goods = new int[mString.length][4];
//        int[] mints = new int[mString.length];
//        int[] nints = new int[mString.length];
//        int[] profits = new int[mString.length];
//        boolean[] isvisited = new boolean[mString.length];
        for(int i=0;i<mString.length;i++){
            goods[i][0] = Integer.parseInt(mString[i]);
            goods[i][1] = Integer.parseInt(nString[i]);
            goods[i][2] = goods[i][1]-goods[i][0];
        }
        Arrays.sort(goods, Comparator.comparingInt(a->a[2]));
        int start = k;
        while (checkList(goods,start)){
            for(int[] good:goods){
                if(start < good[0]|| good[2] <=0 || good[3] ==1){
                    continue;
                }
                start += good[2];
                good[3] = 1;
            }
        }
        System.out.println(start);

    }
    public static boolean checkList(int[][] goods,int f){
        for (int[] good : goods) {
            if (good[3] == 1 || good[2] <= 0) {
                continue;
            }
            if (f > good[0]) {
                return true;
            }
        }
        return false;
    }
}
