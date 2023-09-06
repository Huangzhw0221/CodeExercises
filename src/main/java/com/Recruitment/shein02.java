package com.Recruitment;

import java.util.Scanner;

/**
 * @description: 令牌桶过滤
 * 有一个令牌桶，它的初始容量是100；没过100ms就往里加10个令牌；
 * 如果请求要访问服务就需要过这个令牌桶，从令牌桶中取走一个；如果没有令牌了就拒绝请求；
 * 现在输入形如：
 * 2
 * 100 200
 * 1000 20
 * 第一行输入一个数字，该数字代表后续会有几行；第二行开始的第一个数字是时刻，第二个数字是这个时刻有多少请求送入；
 * 求出拒绝的请求数量；
 *
 * 模拟法，初始化一个100的，没100ms增加10个的桶（数字），然后挨个计算到该时刻拒绝了多少即可。
 * @author: Huang Zhiwei
 * @time: 2023/9/4 20:29
 */
public class shein02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int token = 100,forbidden = 0;
        int pretime = 0;
        for (int i = 0; i < n; i++) {
            int time = in.nextInt();
            int request = in.nextInt();
            token += 10*((time-pretime)/100);
            pretime = time;
            if(request > token){
                forbidden += (request-token);
                token =0;
            }else {
                token -= request;
            }
        }
        System.out.println(forbidden);
    }
}
