package com.wangfei.utils;

import com.wangfei.leecode.ListNode;

public final class ListUtils {

	/**
	 * 将数组转化为链表
	 * @param nums
	 * @return
	 */
	public static ListNode transArrayToList(Integer[] nums){
		if(nums == null || nums.length == 0){
			return null;
		}
		ListNode head = new ListNode(nums[0]);
		ListNode pre = head;
		for(int i = 1; i < nums.length; i++){
			ListNode node = new ListNode(nums[i]);
			pre.next = node;
			pre = node;
		}
		return head;
	} 
	
	public static void printList(ListNode head){
		ListNode cur = head;
		while(cur != null){
			System.out.print(cur.val + "-->");
			cur = cur.next;
		}
		System.out.println("NULL");
	}
}
