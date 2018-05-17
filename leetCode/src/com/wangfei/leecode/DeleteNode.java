package com.wangfei.leecode;

import com.wangfei.utils.ListUtils;

public class DeleteNode {

	public static void main(String[] args) {
		Integer[] nums = {0, 1, 2};
		ListNode list = ListUtils.transArrayToList(nums);
		DeleteNode dn = new DeleteNode();
		ListUtils.printList(list);
		dn.deleteNode(list);
		ListUtils.printList(list);

	}

	/**
	 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾的）节点，您将只被给予要求被删除的节点。
		比如：假设该链表为 1 -> 2 -> 3 -> 4  ，给定您的为该链表中值为 3 的第三个节点，那么在调用了您的函数之后，该链表则应变成 1 -> 2 -> 4 。
	 * @param node
	 */
    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	ListNode temp = node.next;
    	node.next = temp.next;
    	temp = null;
    }
}
