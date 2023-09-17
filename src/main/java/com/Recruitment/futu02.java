package com.Recruitment;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 富图02
 * 打怪问题，可以花费一个金币提升能力，然后求过程中最多拥有多少金币
 * 非常简单的模拟法，先sort以下就可以了。
 * @author: Huang Zhiwei
 * @time: 2023/9/16 14:32
 */
public class futu02 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int a = in.nextInt();
        int count = in.nextInt();
        int[] monsters = new int[count];
        for(int i =0;i<count;i++){
            monsters[i] =  in.nextInt();
        }
        Arrays.sort(monsters);
        int maxmoney =0;
        int money = 0;
        for(int i = 0;i<count;i++){
            if(a + money < monsters[i]){
                System.out.println(maxmoney);
                return;
            }
            if(a >= monsters[i]){
                money+=1;
            }else {
                money -= monsters[i] - a;
                a = monsters[i];
                money+=1;
            }
            maxmoney = Math.max(maxmoney,money);
        }
        System.out.println(maxmoney);
    }
}
