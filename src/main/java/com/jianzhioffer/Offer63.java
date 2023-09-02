package com.jianzhioffer;

import java.util.Stack;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/6/13 13:39
 */
public class Offer63 {
    public static void main(String[] args) {
        int[] input = {5,6};
        System.out.println(getMaxDiff(input, 2));
    }
    public static int getMaxDiff(int[] A, int n) {
        int max_diff = 0;
        int min_val = A[0];
        for (int i = 1; i < n; i++) {
            int diff = A[i] - min_val;
            max_diff = Math.max(max_diff, diff);
            min_val = Math.min(min_val, A[i]);
        }
        return max_diff;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 快慢指针找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 将链表的后半部分压入栈中
        Stack<Integer> stack = new Stack<>();
        ListNode cur = slow.next;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        // 遍历链表的前半部分，同时从栈中弹出元素进行比较
        cur = head;
        while (!stack.isEmpty()) {
            if (cur.val != stack.pop()) {
                return false;
            }
            cur = cur.next;
        }

        return true;
    }
}
