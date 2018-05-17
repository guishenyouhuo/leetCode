package com.wangfei.leecode;

import com.wangfei.utils.TreeUtils;

public class BalancedTree {

	public static void main(String[] args) {

		Integer[] nums = {1,2,2,3,3,null,null,4,4};
		TreeNode root = TreeUtils.arrayToTree(nums);
		BalancedTree bt = new BalancedTree();
		System.out.println(bt.isBalanced(root));
	}
	
	/**
	 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
		本题中，一棵高度平衡二叉树的定义为：
		一棵二叉树中每个节点的两个子树的深度相差不会超过 1。
		示例 1:
		给定二叉树 [3,9,20,null,null,15,7]:
		    3
		   / \
		  9  20
		    /  \
		   15   7
		返回 true 。
		示例 2:
		给定二叉树 [1,2,2,3,3,null,null,4,4]:
		       1
		      / \
		     2   2
		    / \
		   3   3
		  / \
		 4   4
		返回 false 。
	 * @param root
	 * @return
	 */
    public boolean isBalanced(TreeNode root) {
    	if(root == null){
    		return true;
    	}
    	return treeDepth(root) != -1;
    }
    // 递归计算左右子书的高度
    public int treeDepth(TreeNode node){
    	if(node == null){
    		return 0;
    	}
    	int leftDepth = treeDepth(node.left);
    	int rightDepth = treeDepth(node.right);
    	if(leftDepth == -1 || rightDepth == -1){
    		return -1;
    	}
    	if(leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1){
    		return -1;
    	}
    	return Math.max(leftDepth, rightDepth) + 1;
    }

}
