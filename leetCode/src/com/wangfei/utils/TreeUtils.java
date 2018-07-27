package com.wangfei.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.wangfei.leecode.TreeNode;
import com.wangfei.leecode.datastruct.NTreeNode;

public final class TreeUtils {

	/**
	 * 传入数组转为树（按照先序遍历方式）
	 * [3,9,20,null,null,15,7]:
		    3
		   / \
		  9  20
		    /  \
		   15   7
	 * @param nums
	 * @return
	 */
	public static TreeNode arrayToTree(Integer[] nums){
		if(nums == null || nums.length == 0){
			return null;
		}
		TreeNode root = new TreeNode(nums[0]);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		for(int i = 1; i < nums.length; i++){
			TreeNode node = queue.poll();
			if(node == null){
				continue;
			}
			Integer leftVal = nums[i++];
			Integer rightVal = null;
			if(i < nums.length){
				rightVal = nums[i];
			}
			if(leftVal != null){
				node.left = new TreeNode(leftVal);
				queue.offer(node.left);
			}
			if(rightVal != null){
				node.right = new TreeNode(rightVal);
				queue.offer(node.right);
			}
		}
		return root;
	}
	
	public static void listBeforeRoot(TreeNode root){
		if(root == null){
			return;
		}
		System.out.print(root.val + " ");
		listBeforeRoot(root.left);
		listBeforeRoot(root.right);
	}
	
	public static void main(String[] args) {
		Integer[] nums = {3,9,20,null,null,15,7};
		TreeNode root = arrayToTree(nums);
		listBeforeRoot(root);
	}
}
