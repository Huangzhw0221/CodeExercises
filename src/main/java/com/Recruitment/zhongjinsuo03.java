package com.Recruitment;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @description: 2,2,2308,9
 * 6,1,2308,9
 * @author: Huang Zhiwei
 * @time: 2023/9/22 19:47
 */
public class zhongjinsuo03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] inputs = input.split(",");
        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);
        int year = Integer.parseInt(inputs[2].substring(0,2));
        int month = Integer.parseInt(inputs[2].substring(2,4));
        int keep = Integer.parseInt(inputs[3]);
        String proName = "IZ";

        // 生成近月
        PriorityQueue<Integer> nearestMonth = generateNearestMonth(year,month,keep,m);
        // 生成季月
        PriorityQueue<Integer> nearestSeasons = generateNearestSeasons(year,month,keep,n);
        int smallest = 0;
        PriorityQueue<Integer> tempMonth = new PriorityQueue<>();
        PriorityQueue<Integer> tempSeasons = new PriorityQueue<>();
        // 输出第一次的;
        for(int i =0;i<m;i++){
            smallest = nearestMonth.peek();
            tempMonth.add(smallest);
            System.out.print(proName+nearestMonth.poll()+',');
        }
        for(int i =0;i<n;i++){
            while (nearestSeasons.peek() <= smallest){
                nearestSeasons.poll();
            }
            if(i == n-1){
                tempSeasons.add(nearestSeasons.peek());
                System.out.print(proName+nearestSeasons.poll()+'\n');
            }else {
                tempSeasons.add(nearestSeasons.peek());
                System.out.print(proName+nearestSeasons.poll()+',');
            }
        }
        while (keep > 1){
            keep --;
            // 生成
            month += 1;
            if(month >12){
                month -=12;
                year +=1;
            }
            int temptime = year*100 + month;
            try{
                if(temptime > tempMonth.peek()){
                    tempMonth.poll();
                    int u = nearestMonth.peek();
                    if(u == tempSeasons.peek()){
                        tempSeasons.poll();
                        u = nearestSeasons.peek();
                        tempSeasons.add(nearestSeasons.poll());
                    }
                    System.out.println(proName+u);
                    tempMonth.add(nearestMonth.poll());
                }
            }catch (Exception e){
                System.out.println("-");
            }

        }
    }
    public static PriorityQueue<Integer> generateNearestMonth(int startyear, int startmonth, int keep,int m){
        PriorityQueue<Integer> nearestMonth = new PriorityQueue<>();
        while (keep+m > 0){
            nearestMonth.add(startyear*100+startmonth);
            keep --;
            startmonth += 1;
            if(startmonth >12){
                startmonth -=12;
                startyear +=1;
            }
        }
        return nearestMonth;
    }
    public static PriorityQueue<Integer> generateNearestSeasons(int startyear, int startmonth, int keep,int n){
        PriorityQueue<Integer> nearestSeasons = new PriorityQueue<>();
        if(startmonth < 3){
            keep = keep -(3-startmonth);
            startmonth = 3;
        }else if(startmonth <6){
            keep = keep -(6-startmonth);
            startmonth = 6;
        }else if(startmonth <9){
            keep = keep -(9-startmonth);
            startmonth = 9;
        }else if(startmonth <12) {
            keep = keep -(12-startmonth);
            startmonth = 12;
        }

        while (keep+n*3 > 0){
            nearestSeasons.add(startyear*100+startmonth);
            keep --;
            startmonth += 3;
            if(startmonth >12){
                startmonth -=12;
                startyear +=1;
            }
        }
        return nearestSeasons;
    }
}
