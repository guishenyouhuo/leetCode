package com.wangfei.leecode;

import java.util.List;


/**
 * 设计一个支持 push，pop，top 操作，并能在常量时间内检索最小元素的栈。
	push(x) -- 将元素x推入栈中。
	pop() -- 删除栈顶的元素。
	top() -- 获取栈顶元素。
	getMin() -- 检索栈中的最小元素。
	示例:
	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	minStack.getMin();   --> 返回 -3.
	minStack.pop();
	minStack.top();      --> 返回 0.
	minStack.getMin();   --> 返回 -2.
 * @author wangfei
 *
 */
public class MinStack {

	public static void main(String[] args) {

		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());   //--> 返回 -3.
		minStack.pop();
		minStack.top();      //--> 返回 0.
		System.out.println(minStack.getMin());   //--> 返回 -2.
		
//		 MinStack obj = new MinStack();
//		 obj.push(5);
//		 obj.pop();
//		 int param_3 = obj.top();
//		 int param_4 = obj.getMin();
//		 System.out.println(param_3 + param_4);
	}
	
	StackNode[] array;
	int size;
	
    /** initialize your data structure here. */
    public MinStack() {
        this.array = new StackNode[3];
        this.size = 0;
    }
    
    public void push(int x) {
    	// 超出数组限制需要扩充数组
        if(size >= array.length){
        	StackNode[] copy = new StackNode[array.length * 2];
        	System.arraycopy(array, 0, copy, 0, array.length);
        	array = copy;
        }
        int minVal = x;
        if(size > 0){
        	minVal = array[size - 1].minVal;
        }
        if(x < minVal){
        	minVal = x;
        }
        StackNode sn = new StackNode(x, minVal);
        array[size++] = sn;
    }
    
    public void pop() {
    	if(size > 0){
    		array[--size] = null;
    	}
    }
    
    public int top() {
    	if(size > 0){
    		return array[size - 1].val;
    	}
    	return -1;
    }
    
    public int getMin() {
    	if(size > 0){
    		return array[size - 1].minVal;
    	}
        return -1;
    }
    
    public static class StackNode{
    	int val;
    	int minVal;
    	public StackNode(int val, int minVal) {
			this.val = val;
			this.minVal = minVal;
		}
    }

}
