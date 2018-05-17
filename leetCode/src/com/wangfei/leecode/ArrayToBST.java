package com.wangfei.leecode;

public class ArrayToBST {

	public static void main(String[] args) {

		int[] nums = {-10,-3,0,5,9};
		ArrayToBST atb = new ArrayToBST();
		TreeNode root = atb.sortedArrayToBST(nums);
		System.out.println(root);
		atb.midList(root);
	}
	
	/**
	 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
		此题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
		示例:
		给定有序数组: [-10,-3,0,5,9],
		一种可行答案是：[0,-3,9,-10,null,5]，它可以表示成下面这个高度平衡二叉搜索树：
		      0
		     / \
		   -3   9
		   /   /
		 -10  5
	 * @param nums
	 * @return
	 */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
        	return null;
        }
        return binaryProcess(nums, 0, nums.length - 1);
    }
    
    public TreeNode binaryProcess(int[] nums, int begin, int end){
    	if(end < begin){
    		return null;
    	}
    	if(begin == end){
    		return new TreeNode(nums[begin]);
    	}
    	int middle = (begin + end) / 2;
    	TreeNode node = new TreeNode(nums[middle]);
    	node.left = binaryProcess(nums, begin, middle - 1);
    	node.right = binaryProcess(nums, middle + 1, end);
    	return node;
    }
    
    
    public void midList(TreeNode root){
    	if(root == null){
    		return;
    	}
    	midList(root.left);
    	System.out.print(root.val + " ");
    	midList(root.right);
    }

}
