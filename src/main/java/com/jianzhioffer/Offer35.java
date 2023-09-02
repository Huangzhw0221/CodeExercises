package com.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 复杂链表的复制
 * 难点在于对random的实现；可以使用哈希表存放random节点对应的拷贝节点；
 * 递归调用，让节点的random和next分开创建
 * @author: Huang Zhiwei
 * @time: 2023/5/1 17:12
 */
public class Offer35 {
    public static void main(String[] args) {

    }
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        if (!cachedNode.containsKey(head)){
            Node dummy = new Node(head.val);
            cachedNode.put(head,dummy);
            dummy.next = copyRandomList(head.next);
            dummy.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
