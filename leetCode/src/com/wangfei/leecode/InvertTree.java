package com.wangfei.leecode;

import java.util.LinkedList;
import java.util.Queue;

import com.wangfei.utils.TreeUtils;

public class InvertTree {

	public static void main(String[] args) {
		InvertTree it = new InvertTree();
		Integer[] nums = {4,2,7,1,3,6,9};
		TreeNode org = TreeUtils.arrayToTree(nums);
		TreeNode result = it.invertTree(org);
		System.out.println(result);
	}
	
	// 非递归版本
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
        	return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	if(node.left != null){
        		queue.offer(node.left);
        	}
        	if(node.right != null){
        		queue.offer(node.right);
        	}
        	TreeNode left = node.left;
        	node.left = node.right;
        	node.right = left;
        }
    	return root;
    }
	
	// 递归版本
    public TreeNode invertTreeD(TreeNode root) {
        if(root == null){
        	return null;
        }
        TreeNode left = invertTreeD(root.right);
        TreeNode right = invertTreeD(root.left);
        root.left = left;
        root.right = right;
    	return root;
    }

}
