package com.wangfei.leecode;

import java.util.LinkedList;
import java.util.Queue;


public class SeemTree {

	public static void main(String[] args) {

		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		
		TreeNode tree1 = new TreeNode(1);
		tree1.left = new TreeNode(2);
		tree1.right = new TreeNode(3);
		System.out.println(isSameTree(tree, tree1));
	}
	
	/**
	 * 给定两个二叉树，写一个函数来检查它们是否相同。
		如果两棵树在结构上相同并且节点具有相同的值，则认为它们是相同的。
		示例 1:
		输入 :       1         1
		          / \       / \
		         2   3     2   3
		        [1,2,3],   [1,2,3]
		输出: true
		示例 2:
		输入  :      1          1
		          /           \
		         2             2
		        [1,2],     [1,null,2]
		输出: false
		例 3:
		输入 :       1         1
		          / \       / \
		         2   1     1   2
		        [1,2,1],   [1,1,2]
		输出: false
	 * @param p
	 * @param q
	 * @return
	 */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        
    	if(p == null && q == null){
    		return true;
    	}
        if(p == null || q == null){
        	return false;
        }
        Queue<TreeNode> queueP = new LinkedList<TreeNode>();
        Queue<TreeNode> queueQ = new LinkedList<TreeNode>();
        queueP.offer(p);
        queueQ.offer(q);
        while(!queueP.isEmpty() && !queueQ.isEmpty()){
        	TreeNode nodeP = queueP.poll();
        	TreeNode nodeQ = queueQ.poll();
        	if(nodeP == null && nodeQ == null){
        		continue;
        	}
        	if(nodeP == null || nodeQ == null){
        		return false;
        	}
        	if(nodeP.val != nodeQ.val){
        		return false;
        	}
        	queueP.offer(nodeP.left);
        	queueP.offer(nodeP.right);
        	queueQ.offer(nodeQ.left);
        	queueQ.offer(nodeQ.right);
        }
        if(!queueP.isEmpty() || !queueQ.isEmpty()){
        	return false;
        }
    	return true;
    }
    
    // 递归版本
    public static boolean isSameTreeD(TreeNode p, TreeNode q) {
    	if(p == null && q == null){
    		return true;
    	}
        if(p == null || q == null){
        	return false;
        }
        boolean result = p.val == q.val;
    	return result && isSameTreeD(p.left, q.left) && isSameTreeD(p.right, q.right);
    }
    
    // 先序遍历
    public static void printTree(TreeNode tree){
    	if(tree == null){
    		System.out.println("null");
    		return;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(tree);
    	while(!queue.isEmpty()){
    		TreeNode node = queue.poll();
    		if(node == null){
    			System.out.print("null, ");
    			continue;
    		}
    		System.out.print(node.val + ", ");
    		queue.offer(node.left);
    		queue.offer(node.right);
    	}
    }

}
