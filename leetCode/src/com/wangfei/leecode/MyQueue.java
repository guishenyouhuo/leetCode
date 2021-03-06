package com.wangfei.leecode;

import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
	push(x) -- 将一个元素放入队列的尾部。
	pop() -- 从队列首部移除元素。
	peek() -- 返回队列首部的元素。
	empty() -- 返回队列是否为空。
	注意:
	你只能使用标准的栈操作-- 也就是只有push to top, peek/pop from top, size, 和 is empty 操作是合法的。
	你所使用的语言也许不支持栈。你可以使用 list 或者 deque (双端队列) 来模拟一个栈，只要是标准的栈操作即可。
	假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * @author Administrator
 *
 */
public class MyQueue {

	public static void main(String[] args) {
		 MyQueue obj = new MyQueue();
		 obj.push(1);
		 int param_2 = obj.pop();
//		 int param_3 = obj.peek();
		 System.out.println(param_2);
		 boolean param_4 = obj.empty();
		 System.out.println(param_4);
	}
	
	private Stack<Integer> inStack;
	private Stack<Integer> outStack;
	
    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if(outStack.isEmpty()){
    		while(!inStack.isEmpty()){
    			outStack.push(inStack.pop());
    		}
    	}
    	return outStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	if(outStack.isEmpty()){
    		while(!inStack.isEmpty()){
    			outStack.push(inStack.pop());
    		}
    	}
        return outStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

}
