package com.Recruitment;

import com.CodeCaprice.ListNode.ListNode;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description: 报数问题，就是约瑟夫环问题
 *
 * @author: Huang Zhiwei
 * @time: 2023/10/10 10:42
 */
public class dewu03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 人数
        int m = in.nextInt(); // 号码
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0;i< n;i++){
            list.add(i+1);
        }
        boolean flag = true; //true代表正着走，false代表反着走
        // 模拟过程
        int deleteIndex = 0;
        while (list.size() > 1){
            int fontSize = list.size()-1;
            if(flag){
                flag = ((m - 1+deleteIndex) / fontSize) % 2 != 1;
                deleteIndex = flag? (m - 1 + deleteIndex)%fontSize : fontSize-(m-1+deleteIndex)%fontSize;
                list.remove(deleteIndex);
                deleteIndex = flag? deleteIndex:deleteIndex-1;
            }else {
                flag = ((m - 1+fontSize-deleteIndex) / fontSize) % 2 == 1;
                deleteIndex = flag? (m - 1 + fontSize-deleteIndex)%fontSize : fontSize-(m-1+fontSize-deleteIndex)%fontSize;
                list.remove(deleteIndex);
                deleteIndex = flag? deleteIndex:deleteIndex-1;
            }
        }
        System.out.println(list.get(0));
    }
}
