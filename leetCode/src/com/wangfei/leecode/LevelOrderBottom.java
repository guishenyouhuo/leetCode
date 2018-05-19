package com.wangfei.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;


public class LevelOrderBottom {

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
//        list.add(3, new ArrayList<Integer>(1));
        System.out.println(list);

	}
	// 优化版本
	public List<List<Integer>> levelOrderBottomBetter(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null){
        	return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	// 遍历一层
        	int size = queue.size();
        	List<Integer> levelList = new ArrayList<Integer>();
        	for(int i = 0; i < size; i++){
        		TreeNode node = queue.poll();
            	if(node.left != null){
            		queue.offer(node.left);
            	}
            	if(node.right != null){
            		queue.offer(node.right);
            	}
            	levelList.add(node.val);
        	}
        	list.add(0, levelList);
        }
    	return list;
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null){
        	return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        queue.offer(root);
        depthQueue.offer(1);
        List<Integer> depthList = new ArrayList<Integer>();
        depthList.add(root.val);
        SortedMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        map.put(1, depthList);
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	int depth = depthQueue.poll() + 1;
        	if(node.left == null && node.right == null){
        		continue;
        	}
        	List<Integer> elementList = map.get(depth);
        	if(elementList == null){
        		elementList = new ArrayList<Integer>();
        	}
        	if(node.left != null){
        		queue.offer(node.left);
                depthQueue.offer(depth);
                elementList.add(node.left.val);
        	}
        	if(node.right != null){
        		queue.offer(node.right);
                depthQueue.offer(depth);
                elementList.add(node.right.val);
        	}
        	map.put(depth, elementList);
        }
        for(int i = map.lastKey(); i >= map.firstKey(); i--){
        	list.add(map.get(i));
        }
    	return list;
    }

}
