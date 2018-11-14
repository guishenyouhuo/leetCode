package com.wangfei.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.wangfei.leecode.datastruct.NTreeNode;
import com.wangfei.utils.TreeUtils;

public class TreeHandle {

	public static void main(String[] args) {

//		NTreeNode node5 = new NTreeNode(5, null);
//		NTreeNode node6 = new NTreeNode(6, null);
//		List<NTreeNode> node3Children = new ArrayList<NTreeNode>();
//		node3Children.add(node5);
//		node3Children.add(node6);
//		NTreeNode node3 = new NTreeNode(3, node3Children);
//		NTreeNode node2 = new NTreeNode(2, null);
//		NTreeNode node4 = new NTreeNode(4, null);
//		List<NTreeNode> rootChildren = new ArrayList<NTreeNode>();
//		rootChildren.add(node3);
//		rootChildren.add(node2);
//		rootChildren.add(node4);
//		NTreeNode root = new NTreeNode(1, rootChildren);
//		
//		System.out.println(levelOrder(root));
//		
		TreeHandle th = new TreeHandle();
//		int[] res = th.findMode(TreeUtils.arrayToTree(new Integer[]{1,null,2,2}));
//		System.out.println(Arrays.toString(res));
        System.out.println(th.findTilt(TreeUtils.arrayToTree(new Integer[]{1, 2, 3, 4, null, 5})));
	}
	/**
	 * N叉树的层次遍历
	 * @param root
	 * @return
	 */
    public static List<List<Integer>> levelOrder(NTreeNode root) {

    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root == null){
    		return result;
    	}
    	Queue<NTreeNode> queue = new LinkedList<NTreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		List<Integer> levelList = new ArrayList<Integer>();
    		for(int i = 0; i < size; i++){
    			NTreeNode node = queue.poll();
    			levelList.add(node.val);
    			List<NTreeNode> childrenList = node.children;
    			if(childrenList != null){
    				for(NTreeNode treeNode : childrenList){
    					if(treeNode != null){
    						queue.offer(treeNode);
    					}
    				}
    			}
    		}
    		result.add(levelList);
    	}
    	return result;
    }


    /**
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
		假定 BST 有如下定义：
		结点左子树中所含结点的值小于等于当前结点的值
		结点右子树中所含结点的值大于等于当前结点的值
		左子树和右子树都是二叉搜索树
		例如：
		给定 BST [1,null,2,2],

		   1
		    \
		     2
		    /
		   2
		返回[2].

		提示：如果众数超过1个，不需考虑输出顺序

		进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     * @param root
     * @return
     */
    TreeNode pre = null;
    int cnt = 1;
    int max_cnt = 0;
    public int[] findMode(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	midListTree(root, res);
    	int[] result = new int [res.size()];
    	for(int i = 0; i < res.size(); i++){
    		result[i] = res.get(i);
    	}
    	return result;
    }

    private void midListTree(TreeNode node, List<Integer> res){
    	if(node == null){
    		return;
    	}
    	midListTree(node.left, res);
    	if(pre != null){
    		if(node.val == pre.val){
    			++cnt;
    		} else {
    			cnt = 1;
    		}
    	}
    	if(cnt >= max_cnt){
    		if(cnt > max_cnt){
	    		max_cnt = cnt;
	    		res.clear();
    		}
    		res.add(node.val);
    	}
    	if(pre == null){
    		pre = new TreeNode(node.val);
    	} else {
    		pre.val = node.val;
    	}
    	midListTree(node.right, res);
    }

	/**
	 * 给定一个二叉树，计算整个树的坡度。
	 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
	 * 整个树的坡度就是其所有节点的坡度之和。
	 * 示例:
	 * 输入:
	 *          1
	 *        /   \
	 *       2     3
	 * 输出: 1
	 * 解释:
	 * 结点的坡度 2 : 0
	 * 结点的坡度 3 : 0
	 * 结点的坡度 1 : |2-3| = 1
	 * 树的坡度 : 0 + 0 + 1 = 1
	 * 注意:
	 * 任何子树的结点的和不会超过32位整数的范围。
	 * 坡度的值不会超过32位整数的范围。
	 */
	public int findTilt(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int tiltLeft = findTilt(root.left);
		int tiltRight = findTilt(root.right);

		int leftVal = root.left == null ? 0 : root.left.val;
		int rightVal = root.right == null ? 0 : root.right.val;

		root.val += leftVal + rightVal;
		int tiltRoot = Math.abs(leftVal - rightVal);

		return tiltLeft + tiltRight + tiltRoot;
	}
}
