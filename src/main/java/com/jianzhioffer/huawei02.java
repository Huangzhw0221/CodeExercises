package com.jianzhioffer;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/4/19 10:22
 */
public class huawei02 {
    public static void main(String[] args) {
        int[] id =       {0,1,2,3,4,5,6};
        int[] parentid = {1,-1,1,0,4,0,2};
        int[] value = {8,-2,9,-2,3,-3,-3};
        System.out.println(solution(id,parentid,value));
    }
    public static int solution(int[] id,int[] parentid,int[] value){
        //树形dp
        for(int i = 0;i<parentid.length;i++){
            if(parentid[i] == -1){
                continue;
            }
            value[i] = Math.max(value[i],value[i] + value[parentid[i]]);
        }
        int res = 0;
        for(int x:value){
            if(res <x){
                res = x;
            }
        }
        return res;
    }
}
