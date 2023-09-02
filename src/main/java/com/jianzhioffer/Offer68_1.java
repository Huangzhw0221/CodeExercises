package com.jianzhioffer;

/**
 * @description: 二叉搜索树的最近公共祖先
 * 一次遍历，假设要找a和b的公共祖先，对于遍历到的当前节点c，考虑以下三种判断条件 ：
 * c>a&&c>b:应当向c的左子树搜索
 * c<a&&c<b:应当向c的右子树搜索
 * 其他:c就是公共祖先
 * @author: Huang Zhiwei
 * @time: 2023/5/2 0:06
 */
public class Offer68_1 {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else {
            return root;
        }
    }
}
