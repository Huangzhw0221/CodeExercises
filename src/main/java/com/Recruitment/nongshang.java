package com.Recruitment;

import java.util.*;

/**
 * @description: 农商行
 * @author: Huang Zhiwei
 * @time: 2023/10/10 19:56
 */
public class nongshang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        String str = in.next();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = k;i<str.length();i++){
            for(int j = 0;j<=str.length()-i;j++){
                String p = str.substring(j,j+i);
                if(map.containsKey(p)){
                    map.put(p,map.get(p)+1);
                }else {
                    map.put(p,1);
                }
            }
        }
        Set<String> set = map.keySet();
        map.entrySet();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(o1, o2) -> (o2.getValue())- o1.getValue());
        System.out.println(list.get(0).getKey());
    }
}
