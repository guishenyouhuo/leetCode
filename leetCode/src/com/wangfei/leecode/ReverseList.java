package com.wangfei.leecode;

public class ReverseList {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ReverseList rl = new ReverseList();
		rl.printList(head);
		ListNode reverseList = rl.reverseList1(head);
		rl.printList(reverseList);
	}
	// 迭代版本
	public ListNode reverseList1(ListNode head) {
		if(head == null){
    		return null;
    	}
		ListNode current = head;
		ListNode next = head.next;
		while(next != null){
			ListNode curTmp = next;
			ListNode lastTmp = next.next;
			next.next = current;
			current = curTmp;
			next = lastTmp;
		}
		head.next = null;
		return current;
	}
	
	/**
	 * 反转一个单链表。
		进阶:
		链表可以迭代或递归地反转。你能否两个都实现一遍？
	 * @param head
	 * @return
	 */
    public ListNode reverseList(ListNode head) {
    	if(head == null){
    		return null;
    	}
    	ListNode reverseHead = head;
    	while(reverseHead.next != null){
    		reverseHead = reverseHead.next;
    	}
    	ListNode lastNode = reverse(head);
    	lastNode.next = null;
    	return reverseHead;
    }
    
    private ListNode reverse(ListNode head){
    	if(head == null){
    		return null;
    	}
    	ListNode next = reverse(head.next);
    	if(next != null){
    		next.next = head;
    	}
    	return head;
    }
    
    public void printList(ListNode list){
    	while(list != null){
    		System.out.print(list.val + "->");
    		list = list.next;
    	}
    	System.out.println("null");
    }

}
