package com.wangfei.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.wangfei.utils.TreeUtils;

public class TreePath {

	public static void main(String[] args) {

		TreePath tp = new TreePath();
		Integer[] nums = {1,2,3,null,5};
		TreeNode root = TreeUtils.arrayToTree(nums);
		System.out.println(tp.binaryTreePaths(root));
	}
	/**
	 * 给定一个二叉树，返回从根节点到叶节点的所有路径。
		例如，给定以下二叉树:
		   1
		 /   \
		2     3
		 \
		  5
		所有根到叶路径是:
		["1->2->5", "1->3"]
	 * @param root
	 * @return
	 */
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> result = new ArrayList<String>();
    	if(root == null){
    		return result;
    	}
    	Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
    	Queue<String> treePathQueue = new LinkedList<String>();
    	treeNodeQueue.offer(root);
    	treePathQueue.add(root.val + "");
    	while(!treeNodeQueue.isEmpty()){
    		TreeNode treeNode = treeNodeQueue.poll();
    		String treePath = treePathQueue.poll();
    		if(treeNode.left == null && treeNode.right == null){
    			result.add(treePath);
    		}
    		if(treeNode.left != null){
    			treeNodeQueue.offer(treeNode.left);
    			treePathQueue.offer(treePath + "->" + treeNode.left.val);
    		}
    		if(treeNode.right != null){
    			treeNodeQueue.offer(treeNode.right);
    			treePathQueue.offer(treePath + "->" + treeNode.right.val);
    		}
    	}
    	return result;
    }
}
