package com.Recruitment;

import com.jianzhioffer.TreeNode;

import java.util.ArrayList;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/9/30 19:50
 */
public class lixiang01 {
    int zhijing = 0;
    public static void main(String[] args) {

    }
    public int depth(TreeNode root){
        // write code here
        if(root ==null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        zhijing  = Math.max(leftDepth+rightDepth,zhijing);
        return Math.max(leftDepth,rightDepth)+1;
    }
    public int diameterOfBinaryTree (TreeNode root) {
        depth(root);
        return zhijing;
    }

}
