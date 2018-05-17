package com.wangfei.leecode.nodeadd;

import java.util.Stack;

public class TwoNumAdd {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);

		printListNode(l1);
		printListNode(l2);
		
		ListNode l3 = addTwoNumbers(l1, l2);
		printListNode(l3);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int num = 0;
        ListNode l3 = new ListNode((l1.val + l2.val) % 10);
        ListNode lastNode = l3;
        int fullNum = (l1.val + l2.val) / 10;
        l1 = l1.next;
    	l2 = l2.next;
        while(l1 != null && l2 != null){
        	int sum = l1.val + l2.val;
        	num = (sum + fullNum) % 10;
        	ListNode temp = new ListNode(num);
        	lastNode.next = temp;
        	lastNode = temp;
        	fullNum = (sum + fullNum) / 10;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        while(l1 != null){
        	num = l1.val;
        	ListNode temp = new ListNode((num + fullNum) % 10);
        	lastNode.next = temp;
        	lastNode = temp;
        	fullNum = (num + fullNum) / 10;
        	l1 = l1.next;
        }
        while(l2 != null){
        	num = l2.val;
        	ListNode temp = new ListNode((num + fullNum) % 10);
        	lastNode.next = temp;
        	lastNode = temp;
        	fullNum = (num + fullNum) / 10;
        	l2 = l2.next;
        }
        // 新增节点
        if(fullNum > 0){
        	ListNode temp = new ListNode(fullNum);
        	lastNode.next = temp;
        	lastNode = temp;
        }
        
		return l3;
    }
	
	
	public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>(); 
        Stack<Integer> stack2 = new Stack<Integer>();
        while(l1 != null){
        	stack1.add(l1.val);
        	l1 = l1.next;
        }
        while(l2 != null){
        	stack2.add(l2.val);
        	l2 = l2.next;
        }
        int fullNum = 0;
        int num = 0;
        ListNode l3 = null;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
        	int sum = stack1.pop() + stack2.pop();
        	num = (sum + fullNum) % 10;
        	ListNode temp = new ListNode(num);
        	temp.next = l3;
        	l3 = temp;
        	fullNum = (sum + fullNum) / 10;
        }
        while(!stack1.isEmpty()){
        	num = stack1.pop();
        	ListNode temp = new ListNode((num + fullNum) % 10);
        	temp.next = l3;
        	l3 = temp;
        	fullNum = (num + fullNum) / 10;
        }
        while(!stack2.isEmpty()){
        	num = stack2.pop();
        	ListNode temp = new ListNode((num + fullNum) % 10);
        	temp.next = l3;
        	l3 = temp;
        	fullNum = (num + fullNum) / 10;
        }
        
		return l3;
    }
	
	public static void printListNode(ListNode l){
		while(l != null){
			System.out.print(l.val + "->");
			l = l.next;
		}
		System.out.println("null");
	}

}
