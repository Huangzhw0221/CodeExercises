package com.jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description: 包含min函数的栈
 * 两种思路，一种是辅助栈法：用一个辅助的栈存放当前步的最小值，与元素栈同步插入，在插入元素时比较插入值和最小值栈栈顶元素的大小
 * 如果插入值小，那就将插入值同时插入辅助栈的栈顶；反之就复制栈顶元素值插入辅助栈的栈顶；
 *
 * 一种是保存差值法，保存差值的好处是不使用额外空间
 * 保存差值的思路是，存入栈的数字是前后两个数字的差，当插入的数字比前一个大，那么这个差值是正的；反之插入的数字小那就是负的；
 * 出栈的时候，如果栈顶的数字小于零，说明当前值更新了最小值，所以在放出数字前要还原最小值；如果当前值是正数，说明未更新最小值，直接出栈；
 *
 * @author: Huang Zhiwei
 * @time: 2023/4/30 16:39
 */
class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        //初始化的同时，将一个最大数压栈
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(x,minStack.peek()));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
class MinStack2{
    Stack<Long> stack;
    Long min;

    /** initialize your data structure here. */
    public MinStack2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0l);
            min = Long.valueOf(x);
        } else {
            stack.push((long) (x - min));
            min = Math.min(x, min);
        }
    }

    public void pop() {
        if (stack.peek() < 0) {
            min = min - stack.pop();
            return;
        }
        stack.pop();
    }

    public int top() {
        if (stack.peek() > 0) {
            return (int) (min + stack.peek());
        } else {
            return Math.toIntExact(min);
        }
    }

    public int min() {
        return Math.toIntExact(min);
    }
}
