package com.wangfei.leecode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeList {

	public static void main(String[] args) {

		PalindromeList pl = new PalindromeList();
		ListNode head = new ListNode(1);
//		head.next = new ListNode(1);
//		head.next.next = new ListNode(1);
//		head.next.next.next = new ListNode(1);
//		head.next.next.next.next = new ListNode(1);
		System.out.println(pl.isPalindrome1(head));
	}
	
	// 进阶版本 快慢指针加逆转链表
	public boolean isPalindrome1(ListNode head) {
		if(head == null){
			return true;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		if(fast == null){
			return true;
		}
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next;
			if(fast != null){
				fast = fast.next;
			}
		}
		// 从slow下一个开始逆转，头插法
		ListNode first = slow.next;
		ListNode curNode = first.next;
		first.next = null;
		while(curNode != null){
			ListNode next = curNode.next;
			curNode.next = first;
			first = curNode;
			curNode = next;
		}
		
		// 判断前半部分与和逆转后的后半部分是否一样
		ListNode topHalf = head;
		while(first != null){
			if(topHalf.val != first.val){
				return false;
			}
			topHalf = topHalf.next;
			first = first.next;
		}
		return true;
	}
	
    public boolean isPalindrome(ListNode head) {
        
    	if(head == null){
    		return true;
    	}
    	List<Integer> valList = new ArrayList<Integer>();
    	ListNode current = head;
    	while(current != null){
    		valList.add(current.val);
    		current = current.next;
    	}
    	int begin = 0;
    	int end = valList.size() - 1;
    	while(begin < end){
//    		if(valList.get(begin) != valList.get(end)){
//    			return false;
//    		}
    		if(!valList.get(begin).equals(valList.get(end))){
    			return false;
    		}
    		++begin;
    		--end;
    	}
    	return true;
    }

}
