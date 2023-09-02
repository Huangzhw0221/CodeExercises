package com.jianzhioffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @description: 栈的压入、弹出序列
 * 使用模拟法，创建一个栈，进入循环；循环的终止条件是两个数组下标一起越界了；当栈为空且pushed数组下标未越界，那就压栈一个数字；
 * 比较poped数组下标位置元素和栈顶元素，如果相同，就出栈，否则继续压栈；
 * 也有官网给出的简洁写法
 * @author: Huang Zhiwei
 * @time: 2023/4/30 17:05
 */
public class Offer31 {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] poped = {4,5,3,2,1};
//        int[] pushed = {0,2,1};
//        int[] poped = {0,1,2};
        System.out.println(validateStackSequences(pushed, poped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped){
        if(pushed.length != popped.length){
            return false;
        }
        if(pushed.length == 0){
            return true;
        }
        if(pushed.length == 1){
            return pushed[0] == popped[0];
        }
        Stack<Integer> stack = new Stack<>();
        int popindex = 0;
        int pushindex = 0;
        stack.push(pushed[pushindex++]);
        while(pushindex < pushed.length || popindex <popped.length){
            if(stack.isEmpty()){
                if(pushindex >= pushed.length){
                    return false;
                }
                stack.push(pushed[pushindex++]);
            }
            if(stack.peek() != popped[popindex]){
                if(pushindex >= pushed.length){
                    return false;
                }
                stack.push(pushed[pushindex++]);
            }else {
                popindex++;
                stack.pop();
            }
        }
        return true;
    }
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
