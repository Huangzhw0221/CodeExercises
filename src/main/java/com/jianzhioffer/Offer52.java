package com.jianzhioffer;

/**
 * @description: 两个链表的第一个公共节点
 * 双指针法，两个指针一开始指向A的头和B的头，如果指向同一个节点了，那就返回这个节点，无论是否为空；
 * 如果一个指针指向空了，如果是A就将A指向B的头，是B就将B指向A的头；
 * @author: Huang Zhiwei
 * @time: 2023/5/2 14:33
 */
public class Offer52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
