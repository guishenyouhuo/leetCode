package com.wangfei.leecode;

import java.util.LinkedList;
import java.util.Queue;

import com.wangfei.utils.TreeUtils;

public class HasPathSum {

	public static void main(String[] args) {
		Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};
		TreeNode root = TreeUtils.arrayToTree(nums);
		HasPathSum hps = new HasPathSum();
		System.out.println(hps.hasPathSum(root, 22));

	}
	
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
        	return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty()){
        	TreeNode node = nodeQueue.poll();
        	if(node.left == null && node.right == null){
        		if(node.val == sum){
        			return true;
        		}
        		continue;
        	}
        	if(node.left != null){
        		node.left.val += node.val;
        		nodeQueue.offer(node.left);
        	}
        	if(node.right != null){
        		node.right.val += node.val;
        		nodeQueue.offer(node.right);
        	}
        }
    	return false;
    }

}
