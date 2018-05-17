package com.wangfei.leecode;

import java.util.LinkedList;
import java.util.Queue;

import com.wangfei.utils.TreeUtils;

public class MinDepth {

	public static void main(String[] args) {

		Integer[] nums = {1,2,2,3,3,null,null,4,4};
		TreeNode root = TreeUtils.arrayToTree(nums);
		MinDepth md = new MinDepth();
		System.out.println(md.minDepth(root));
	}
	
	/**
	 * 
		给定一个二叉树，找出其最小深度。
		最小深度是从根节点到最近叶节点的最短路径的节点数量。
	 * @param root
	 * @return
	 */
    public int minDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()){
        	int size = queue.size();
        	for(int i = 0; i < size; i++){
        		TreeNode node = queue.poll();
        		if(node.left == null && node.right == null){
        			return depth;
        		}
        		if(node.left != null){
        			queue.offer(node.left);
        		}
        		if(node.right != null){
        			queue.offer(node.right);
        		}
        	}
        	++depth;
        }
    	return depth;
    }

}
