package com.wangfei.leecode.mergelink;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class MergeLink {

	/**
	 * 合并两个已排序的链表，并将其作为一个新列表返回。新列表应该通过拼接前两个列表的节点来完成。 
		示例：
		输入：1->2->4, 1->3->4
		输出：1->1->2->3->4->4
	 * @param args
	 */
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(7);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		printList(l1);
		printList(l2);
		
		printList(mergeTwoLists1(l1, l2));
	}
	
	
	public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null){
			return null;
		}
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		if(l1.val > l2.val){
			return mergeTwoLists(l2, l1);
		}
		ListNode result = l1;
		ListNode previous = l1;
		l1 = l1.next;
		int val1, val2;
        while(l1 != null || l2 != null){
        	val1 = Integer.MAX_VALUE;
        	val2 = Integer.MAX_VALUE;
        	if(l1 != null){
        		val1 = l1.val;
        	}
        	if(l2 != null){
        		val2 = l2.val;
        	}
        	if(val2 < val1){
        		previous.next = l2;
        		previous = l2;
        		l2 = l2.next;
        	} else {
        		previous.next = l1;
        		previous = l1;
        		l1 = l1.next;
        	}
        }
		return result;
    }
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null){
			return null;
		}
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		if(l1.val > l2.val){
			return mergeTwoLists(l2, l1);
		}
		ListNode result = l1;
		ListNode previous = l1;
		l1 = l1.next;
        while(l1 != null && l2 != null){
        	if(l2.val < l1.val){
        		previous.next = l2;
        		previous = l2;
        		l2 = l2.next;
        	} else {
        		previous.next = l1;
        		previous = l1;
        		l1 = l1.next;
        	}
        }
        while(l1 != null){
        	previous.next = l1;
    		previous = l1;
    		l1 = l1.next;
        }
        while(l2 != null){
        	previous.next = l2;
    		previous = l2;
    		l2 = l2.next;
        }
		return result;
    }
	
	public static void printList(ListNode list){
		while(list != null){
			System.out.print(list.val + "->");
			list = list.next;
		}
		System.out.println("null");
	}

}
