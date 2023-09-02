package com.jianzhioffer;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/4/19 15:23
 */
public class Offer22 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(getKthFromEnd(head, 2).val);
    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        //用前后节点的方法
        ListNode dummy = head;
        while(k > 0){
            dummy = dummy.next;
            k --;
        }
        while(dummy != null){
            head = head.next;
            dummy = dummy.next;
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
