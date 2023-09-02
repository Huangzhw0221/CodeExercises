package com.jianzhioffer;

import java.awt.print.PrinterGraphics;

import static com.jianzhioffer.Offer37_2.deserialize;

/**
 * @description: 平衡二叉树
 * [1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]
 * @author: Huang Zhiwei
 * @time: 2023/5/1 23:38
 */
public class Offer55_2 {
    public static void main(String[] args) {
        String input ="1 2 2 3 3 3 3 4 4 4 4 4 4 null null 5 5";
        TreeNode out = deserialize(input);
        System.out.println(isBalanced(out));
    }
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return balanceHelper(root,0,0);
    }
    static int min = Integer.MAX_VALUE;
    public static boolean balanceHelper(TreeNode node,int temp,int max){
        //层数差大于等于2就返回false
        if(max - min >=2) return false;
        //第一次出现null时，就固定下min的层数值
        if(node.right == null || node.left == null) {
            min = Math.min(min,temp);
        }
        if(node.right == null && node.left == null){
            return max - min < 2;
        }
        boolean right = true;
        boolean left = true;
        if(node.right != null){
            right = balanceHelper(node.right,temp+1,max+1);
        }
        if(node.left != null){
            left = balanceHelper(node.left,temp+1,max+1);
        }
        return right&&left;
    }
}
