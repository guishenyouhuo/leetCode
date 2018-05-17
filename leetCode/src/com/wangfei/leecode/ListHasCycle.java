package com.wangfei.leecode;

public class ListHasCycle {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		ListHasCycle lhc = new ListHasCycle();
		System.out.println(lhc.hasCycle(head));
		System.out.println(lhc.detectCycle(head).val);
	}
	
    public ListNode detectCycle(ListNode head) {
    	if(head == null){
    		return null;
    	}
    	// 快指针和慢指针（有环会相遇）
        ListNode slow = head;
        ListNode fast = slow.next;
        boolean hasCycle = false;
        while(slow != null && fast != null){
        	if(fast == slow){
        		hasCycle = true;
        		break;
        	}
        	slow = slow.next;
        	fast = fast.next;
        	if(fast != null){
        		fast = fast.next;
        	}
        }
        if(!hasCycle){
        	return null;
        }
        int cycleCount = 1;
        ListNode start = slow;
        slow = slow.next;
        while(slow != null){
        	if(slow == start){
        		break;
        	}
        	++cycleCount;
        	slow = slow.next;
        }
        ListNode p = head;
        ListNode q= head;
        while(cycleCount > 0){
        	p = p.next;
        	--cycleCount;
        }
        while(p != q){
        	p = p.next;
        	q = q.next;
        }
    	return p;
    }
	
	/**
	 * 给定一个链表，判断链表中否有环。
		补充：
		你是否可以不用额外空间解决此题？
	 * @param head
	 * @return
	 */
    public boolean hasCycle(ListNode head) {
    	if(head == null){
    		return false;
    	}
    	// 快指针和慢指针（有环会相遇）
        ListNode slow = head;
        ListNode fast = slow.next;
        while(slow != null && fast != null){
        	if(fast == slow){
        		return true;
        	}
        	slow = slow.next;
        	fast = fast.next;
        	if(fast != null){
        		fast = fast.next;
        	}
        }
    	return false;
    }
}
