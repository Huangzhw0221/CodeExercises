package com.CodeCaprice.Greedy;

/**
 * @description: 买卖股票的最佳时机Ⅱ
 * 给定一个数组，它的第  i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 核心思想是分解利润然后计算正的利润和。创建一个比原始数组长度小1 的数组代表第i+1天减去第i天的利润，如果这个利润是正的那就求和。
 * @author: Huang Zhiwei
 * @time: 2023/9/2 21:55
 */
public class Greedy04maxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int[] profits = new int[prices.length-1];
        int total = 0;
        for(int i = 0;i<prices.length-1;i++){
            profits[i] = prices[i+1] - prices[i];
            if(profits[i] >0){
                total += profits[i];
            }
        }
        return total;
    }
}
