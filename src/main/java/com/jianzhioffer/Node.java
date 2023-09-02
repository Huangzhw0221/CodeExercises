package com.jianzhioffer;

/**
 * @description: 复杂节点
 * @author: Huang Zhiwei
 * @time: 2023/5/1 17:12
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
