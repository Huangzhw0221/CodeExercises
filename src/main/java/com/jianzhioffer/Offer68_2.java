package com.jianzhioffer;

/**
 * @description: 二叉树的最近公共祖先
 * 对于不是二叉搜索树的情况，同样可以使用递归
 * 题解摘自leetcode评论区
 * @author: Huang Zhiwei
 * @time: 2023/5/2 13:30
 */
public class Offer68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        如果根节点为空直接返回null
        if(root == null){
            return null;
        }
//        第一个找到的节点为q说明q比p深度小,位于p上方,直接返回q
        if(root.val == q.val){
            return q;
//        第一个找到的节点为p说明p比q深度小,位于q上方,直接返回p
        }else if(root.val == p.val){
            return p;
        }else {
//            left和right分别表示向左右递归得到的结果
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);
//            如果left和right都不为空说明两个节点在根节点左右,直接返回根节点
            if(left != null && right != null){
                return root;
//            如果左边递归为空说明两个节点都在右边,且right节点一定是p,q的根节点,直接返回right节点
            }else if(left == null){
                return right;
            }else {
//            如果右递归为空说明两个节点都在左边,且left节点一定是p,q的根节点,直接返回left节点
                return left;
            }
        }
    }
}
