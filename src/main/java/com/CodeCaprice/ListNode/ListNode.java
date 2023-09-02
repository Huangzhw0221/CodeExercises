package com.CodeCaprice.ListNode;

/**
 * @description: 链表节点类
 * @author: Huang Zhiwei
 * @time: 2023/8/31 22:26
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
