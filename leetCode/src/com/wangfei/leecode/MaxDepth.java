package com.wangfei.leecode;

public class MaxDepth {

	public static void main(String[] args) {

		
	}
	
    public int maxDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
    public int maxDepth1(TreeNode root) {
        if(root == null){
        	return 0;
        }
        
        int depth = 1;
        while(root.left != null || root.right != null){
        	
        }
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
