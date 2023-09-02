package com.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 从上到下打印二叉树 II
 * 和102题层序遍历相同，我们使用一个List<List<Integer>>存放答案；内部嵌套的就是每一层构成的List<Integer>；
 * 这里我使用一个标记nextLayercount标记
 * @author: Huang Zhiwei
 * @time: 2023/4/30 20:30
 */
public class Offer32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //特殊情况，为空时直接返回
        if(root==null)return new ArrayList<>();
        //tempLayercount表示当前层还剩余几个节点需要打印；nextLayercount表示下一层共有几个节点需要打印
        int tempLayercount = 1;
        int nextLayercount = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> innerans = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            innerans.add(node.val);
            //左右节点不为空就将当前节点的左右节点加入队列，且下一层的计数加一
            if(node.left!=null) {queue.add(node.left);nextLayercount+=1;}
            if(node.right!=null) {queue.add(node.right);nextLayercount+=1;}
            //当前层的计数器减一，如果减到零了就将当前层加入到总的答案list中去
            tempLayercount -= 1;
            if(tempLayercount == 0){
                tempLayercount = nextLayercount;
                if(!innerans.isEmpty()){ans.add(innerans);}
                innerans = new ArrayList<>();
                nextLayercount = 0;
            }
        }
        if(!innerans.isEmpty()){ans.add(innerans);}
        return ans;
    }
}
