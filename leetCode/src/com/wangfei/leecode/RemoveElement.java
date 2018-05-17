package com.wangfei.leecode;

public class RemoveElement {

	public static void main(String[] args) {

		
	}
	
	/**
	 * 删除链表中等于给定值 val 的所有元素。
		示例
		给定: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
		返回: 1 --> 2 --> 3 --> 4 --> 5
	 * @param head
	 * @param val
	 * @return
	 */
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
        	head = head.next;
        }
        if(head == null){
        	return null;
        }
        ListNode previous = head;
        ListNode current = head.next;
        while(current != null){
        	if(current.val == val){
        		previous.next = current.next;
        	} else {
        		previous = current;
        	}
        	current = current.next;
        }
    	return head;
    }

}
