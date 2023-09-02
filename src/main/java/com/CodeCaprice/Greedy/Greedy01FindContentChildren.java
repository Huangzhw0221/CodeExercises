package com.CodeCaprice.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @description: 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值  g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，
 * 都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 思路是模拟这个投喂过程，从饼干的视角，让大饼干喂给可以喂的胃口最大的小孩。
 * @author: Huang Zhiwei
 * @time: 2023/9/1 23:13
 */
public class Greedy01FindContentChildren {
    public static void main(String[] args) {
        // g是胃口
        int[] g = new int[]{1,2};
        // s是饼干
        int[] s = new int[]{1,2,3};
        System.out.println(findContentChildren(g,s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        // 从优先考虑胃口的角度看，让大的饼干去喂饱胃口大的小孩
        // 先进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        // 代表饼干已经选到最大的那块了
        int start = s.length -1;
        // 从末尾开始遍历小孩的胃口，先找胃口最大的那个值
        for(int index = g.length-1;index >= 0;index--){
            // 如果小孩的胃口比这个最大的饼干还要大，那就向下走
            if(start >= 0 && g[index] <=s[start]){
                start --;
                count ++;
            }
        }
        return count;
    }
}

