package com.jianzhioffer;

/**
 * @description: 树节点
 * @author: Huang Zhiwei
 * @time: 2023/4/30 20:22
 */
public class TreeNode {
     int val;
     public TreeNode left;
     public TreeNode right;
     TreeNode(int x) { val = x; }
     public TreeNode(int _val,TreeNode _left,TreeNode _right) {
          val = _val;
          left = _left;
          right = _right;
     }
}
