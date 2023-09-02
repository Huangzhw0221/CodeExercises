package com.CodeCaprice.ListNode;

import java.util.HashSet;

/**
 * @description: 环形链表
 * 经典快慢指针法如方法A，也可以使用哈希集合法如方法B，这道题是比较简单的。
 * 需要注意的是返回的listnode是环的入口，不是相遇的任意节点。
 * 哈希集合的方法空间复杂度就不是1 了
 *
 * @author: Huang Zhiwei
 * @time: 2023/9/1 22:43
 */
public class ListNode07DetectCycle {
    public static void main(String[] args) {
        ListNode listNode = ListNode00GenerateListNode.generateListNodeFromArray(new int[]{1,2,3,4,5});
        listNode.next.next.next.next = listNode.next.next;
        ListNode00GenerateListNode.printListNode(detectCycleA(listNode));
    }
    public static ListNode detectCycleA(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
    public static ListNode detectCycleB(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null){
            if(set.contains(head)){
                return head;
            }else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
