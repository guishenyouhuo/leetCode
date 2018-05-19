package com.wangfei.leecode;

public class DeleteDuplicates {

	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(1);
		list.next.next = new ListNode(2);
		list.next.next.next = new ListNode(3);
		list.next.next.next.next = new ListNode(3);
		
		printList(list);
		
		printList(deleteDuplicates(list));

	}
	/**
	 * 给定一个排序链表，删除所有重复的元素使得每个元素只留下一个。
		案例：
		给定 1->1->2，返回 1->2
		给定 1->1->2->3->3，返回 1->2->3
	 * @param head
	 * @return
	 */
    public static ListNode deleteDuplicates(ListNode head) {
    	if(head == null){
    		return null;
    	}
        ListNode previous = head;
        ListNode current = head;
        while(current != null){
        	if(previous.val == current.val){
        		previous.next = current.next;
        	} else {
        		previous = current;
        	}
        	current = current.next;
        }
    	return head;
    }
    
    public static void printList(ListNode list){
    	if(list == null){return;}
    	while(list.next != null){
    		System.out.print(list.val + "->");
    		list = list.next;
    	}
    	System.out.println(list.val);
    }

}
