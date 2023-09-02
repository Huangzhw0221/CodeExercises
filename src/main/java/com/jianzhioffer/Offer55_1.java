package com.jianzhioffer;

import static com.jianzhioffer.Offer37_2.deserialize;

/**
 * @description: 二叉树的深度
 * 构造一个辅助函数findMaxDepth，传入节点和当前层数，然后递归调用findMaxDepth，比较左右子树中深度较大的那个。
 * @author: Huang Zhiwei
 * @time: 2023/5/1 23:26
 */
public class Offer55_1 {
    public static void main(String[] args) {
        String input ="5 3 6 2 4 null null 1";
        TreeNode out = deserialize(input);
        System.out.println(maxDepth(out));
    }
    public static int maxDepth(TreeNode root) {
        return findMaxDepth(root,0);
    }
    public static int findMaxDepth(TreeNode node,int layer){
        if(node != null){
            layer +=1;
        }else return layer;
        return Math.max(findMaxDepth(node.left,layer),findMaxDepth(node.right,layer));
    }
}
