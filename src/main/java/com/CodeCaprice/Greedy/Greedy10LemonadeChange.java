package com.CodeCaprice.Greedy;

/**
 * @description: 柠檬水找零
 * 思路：有三种情况：1—收到5美元，直接收下；2—收到10美元，那么找零5美元；3—收到20美元，
 * 由于5美元具有更高的通用性，因此优先找零10美元+5美元，如果不够了再找零3个5美元；
 *
 * 基于此，可以用两个数字存储5美元的数量和10美元的数量。然后根据策略操作即可。如果出现数量小于0 的情况就结束。
 * @author: Huang Zhiwei
 * @time: 2023/9/17 16:38
 */
public class Greedy10LemonadeChange {
    public static void main(String[] args) {
        int[] ints = {5,5,5,10,20};
        System.out.println(lemonadeChange(ints));
    }
    public static boolean lemonadeChange(int[] bills) {
        int fiveDollerCount = 0;
        int tenDollerCount =0;
        for(int bill:bills){
            switch (bill){
                case 5:{fiveDollerCount++;break;}
                case 10:{tenDollerCount++;fiveDollerCount--;break;}
                case 20:{
                    if (tenDollerCount >= 1) {
                        tenDollerCount--;
                        fiveDollerCount--;
                    } else {
                        fiveDollerCount -= 3;
                    }
                }
            }
            if(fiveDollerCount <0 || tenDollerCount <0){
                return false;
            }
        }
        return true;
    }
}
