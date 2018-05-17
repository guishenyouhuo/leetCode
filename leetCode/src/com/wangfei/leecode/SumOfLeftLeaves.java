package com.wangfei.leecode;

import java.util.LinkedList;
import java.util.Queue;

import com.wangfei.utils.TreeUtils;

public class SumOfLeftLeaves {

	public static void main(String[] args) {

		SumOfLeftLeaves soll = new SumOfLeftLeaves();
		TreeNode root = TreeUtils.arrayToTree(new Integer[]{3,9,20,null,null,15,7});
		System.out.println(soll.sumOfLeftLeaves(root));
	}
	
	/**
	 * 计算给定二叉树的所有左叶子之和。
		示例：
		    3
		   / \
		  9  20
		    /  \
		   15   7
		在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
	 * @param root
	 * @return
	 */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
        	return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int result = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	TreeNode left = node.left;
        	TreeNode right = node.right;
        	if(left != null){
        		if(left.left == null && left.right == null){
        			result += left.val;
        		} else {
        			queue.offer(left);
        		}
        	}
        	if(right != null){
        		queue.offer(right);
        	}
        }
    	return result;
    }

}
