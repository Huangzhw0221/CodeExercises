package com.CodeCaprice.ListNode;

/**
 * @description: 设计链表
 * @author: Huang Zhiwei
 * @time: 2023/9/1 16:34
 */
public class ListNode02MyLinkedList {
    ListNode head;
    int size;
    ListNode02MyLinkedList(){
        head = new ListNode(0);
        size = 0;
    }
    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
    public int get(int index) {
        if(index < 0 || index > size-1){
            return -1;
        }
        ListNode cur = head;
        while (index >= 0 ){
            cur = cur.next;
            index --;
        }
        return cur.val;
    }
    //在链表最前面插入一个节点，等价于在第0个元素前添加
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    //在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }
    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index <0){index = 0;}
        size++;
        ListNode pre = head;
        for(int i = 0;i< index;i++){
            pre = pre.next;
        }
        ListNode toAdd = new ListNode(val);
        // 打断，把前后分别拼接起来
        toAdd.next = pre.next;
        pre.next = toAdd;
    }
    //删除第index个节点
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0){
            return;
        }
        size--;
        if(index == 0){
            head = head.next;
            return;
        }
        ListNode pre = head;
        for(int i = 0;i< index;i++){
            pre = pre.next;
        }
        // 打断，把前后分别拼接起来
        pre.next = pre.next.next;
    }
}
