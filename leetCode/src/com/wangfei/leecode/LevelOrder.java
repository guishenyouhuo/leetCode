package com.wangfei.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.wangfei.utils.TreeUtils;

public class LevelOrder {

	public static void main(String[] args) {
		Integer[] nums = {3,9,20,null,null,15,7};
		TreeNode root = TreeUtils.arrayToTree(nums);
		LevelOrder lo = new LevelOrder();
		System.out.println(lo.levelOrder(root));

	}
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root == null){
    		return result;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		List<Integer> levelList = new ArrayList<Integer>();
    		for(int i = 0; i < size; i++){
    			TreeNode node = queue.poll();
    			levelList.add(node.val);
    			if(node.left != null){
    				queue.offer(node.left);
    			}
    			if(node.right != null){
    				queue.offer(node.right);
    			}
    		}
    		result.add(levelList);
    	}
    	return result;
    }

}
