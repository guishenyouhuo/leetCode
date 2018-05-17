package com.wangfei.leecode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(2);
		
		tree.left.left = new TreeNode(3);
		tree.left.right = new TreeNode(4);
		
		tree.right.left = new TreeNode(4);
		tree.right.right = new TreeNode(3);

		System.out.println(isSymmetric(tree));
	}
	
	/**
	 * 给定一个二叉树，检查它是否是它自己的镜像（即，围绕它的中心对称）。
		例如，这个二叉树 [1,2,2,3,4,4,3] 是对称的。
		    1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
		但是下面这个 [1,2,2,null,3,null,3] 则不是:
		    1
		   / \
		  2   2
		   \   \
		   3    3
	 * @param root
	 * @return
	 */
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
        	return true; 
        }
    	return isSameTreeD(root.left, root.right);
    }
    
    public static boolean isSameTreeD(TreeNode p, TreeNode q) {
    	if(p == null && q == null){
    		return true;
    	}
        if(p == null || q == null){
        	return false;
        }
        boolean result = p.val == q.val;
    	return result && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
    
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
        	queueQ.offer(nodeQ.right);
        	queueQ.offer(nodeQ.left);
        }
        if(!queueP.isEmpty() || !queueQ.isEmpty()){
        	return false;
        }
    	return true;
    }

}
