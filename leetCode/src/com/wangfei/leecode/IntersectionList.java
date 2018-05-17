package com.wangfei.leecode;

public class IntersectionList {

	public static void main(String[] args) {

		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		a1.next = a2;
		
		ListNode b1 = new ListNode(3);
		ListNode b2 = new ListNode(4);
		ListNode b3 = new ListNode(5);
		b1.next = b2;
		b2.next = b3;
		
		ListNode c1 = new ListNode(6);
		ListNode c2 = new ListNode(7);
		ListNode c3 = new ListNode(8);
		c1.next = c2;
		c2.next = c3;
		
		a2.next = c1;
		b3.next = c1;
		
		IntersectionList il = new IntersectionList();
		
		ListNode node = il.getIntersectionNode(a1, b1);
		System.out.println(node.val);
	}
	
	/**
	 * 编写一个程序，找到两个单链表相交的起始节点。
		例如，下面的两个链表：
		A:          a1 → a2
		                   	↘
		                     c1 → c2 → c3
		                   	↗            
		B:     b1 → b2 → b3
		在节点 c1 开始相交。
		注意：
		如果两个链表没有交点，返回 null.
		在返回结果后，两个链表仍须保持原有的结构。
		可假定整个链表结构中没有循环。
		程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
	 * @param headA
	 * @param headB
	 * @return
	 */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA == null || headB == null){
    		return null;
    	}
    	ListNode p = headA;
    	ListNode q = headB;
    	while(p != null && q != null){
    		if(p == q){
    			return p;
    		}
    		p = p.next;
    		q = q.next;
    	}
    	ListNode longNode = null;
    	ListNode shortNode = null;
    	if(p != null || q != null){
    		longNode = headA;
    		shortNode = headB;
	    	if(q != null){
	    		p = q;
	    		longNode = headB;
	    		shortNode = headA;
	    	}
			while(p != null && longNode != null){
				p = p.next;
				longNode = longNode.next;
			}
    	}
    	while(longNode != null && shortNode != null){
    		if(longNode == shortNode){
    			return longNode;
    		}
    		longNode = longNode.next;
    		shortNode = shortNode.next;
    	}
    	return null;
    }
    
}
