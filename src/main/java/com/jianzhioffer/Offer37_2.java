package com.jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 序列化二叉树
 * 构造一个辅助栈存放父节点
 * 需要注意的是如果父节点的左右子树为空，那么需要将null添加进StringBuilder中
 * @author: Huang Zhiwei
 * @time: 2023/5/1 20:13
 */
public class Offer37_2 {
    public static void main(String[] args) {
        String input ="1 2 3 null null 4 5 null null null null";
        TreeNode out = deserialize(input);
        System.out.println("finished");
        System.out.println(serialize(out));
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null){
            return "null ";
        }
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            TreeNode temp = treeNodes.pop();
            if(temp == null){
                sb.append("null ");
                continue;
            }
            sb.append(temp.val);
            sb.append(" ");
            if(temp.left != null){
                treeNodes.add(temp.left);
            }else {
                treeNodes.add(null);
            }
            if(temp.right !=  null){
                treeNodes.add(temp.right);
            }else {
                treeNodes.add(null);
            }

        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals("null ")){
            return null;
        }
        String[] dataqueue = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(dataqueue[0]));
        //构造辅助栈
        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        TreeNode fatherNode = treeNodes.peek();
        TreeNode tempNode = null;
        for(int i = 1;i<dataqueue.length;i++){
            fatherNode = treeNodes.peek();
            if(dataqueue[i].equals("null") ){
                if((i+1) %2 == 0){
                    fatherNode.left = null;
                }else {
                    fatherNode.right = null;
                    treeNodes.pop();
                }
                continue;
            }
            tempNode = new TreeNode(Integer.parseInt(dataqueue[i]));
            if((i+1) %2 == 0){
                fatherNode.left = tempNode;
                treeNodes.add(tempNode);
            }else {
                fatherNode.right = tempNode;
                treeNodes.add(tempNode);
                treeNodes.pop();
            }
        }
        return root;
    }
}
