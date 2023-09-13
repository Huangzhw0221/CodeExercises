package com.Recruitment;

import java.util.Scanner;

/**
 * 1. @ClassDescription:给出一组频率和对应的损失，计算最相近的频率的损失和
 *主要就是切分，好像没啥难度
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年09月02日16:40
 */
public class xiaomi01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int freq = in.nextInt();
        String freq_loss = in.next();
//切分频率和损失
        String[] tempfreq = freq_loss.split(",");
        int[][] freqs = new int[tempfreq.length][2];
        int count = 0;
//构造频率-损失数组
        for(String s:tempfreq){
            freqs[count][0] = Integer.parseInt(s.split(":")[0]);
            freqs[count][1] = Integer.parseInt(s.split(":")[1]);
            count++;
        }
//初始化距离和结果
        double lowestDistance = Double.POSITIVE_INFINITY;
        double result = 0;
//遍历一次。也可以使用二分查找快速找到最相近的频率
        for(int i = 0;i< freqs.length;i++){
            double distance = Math.abs(freqs[i][0]-freq);
            if(distance < lowestDistance){
                lowestDistance = distance;
                result = freqs[i][1];
            } else if (distance ==  lowestDistance) {
                result = (result+ freqs[i][1]) /2;
            }
        }
        System.out.println(result);
    }
}

