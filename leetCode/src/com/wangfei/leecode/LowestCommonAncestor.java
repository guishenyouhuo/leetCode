package com.wangfei.leecode;

import com.wangfei.utils.ListUtils;
import com.wangfei.utils.TreeUtils;

public class LowestCommonAncestor {

	public static void main(String[] args) {

		LowestCommonAncestor lca = new LowestCommonAncestor();
		Integer[] nums = {6,2,8,0,4,7,9,null,null,3,5};
		TreeNode root = TreeUtils.arrayToTree(nums);
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(8);
		TreeNode commonFather = lca.lowestCommonAncestor1(root, p, q);
		System.out.println(commonFather.val);
	}
	
	/**
	 * 给定一棵二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
		百度百科中最近公共祖先的定义： “对于有根树T的两个结点u、v，最近公共祖先表示一个结点x，满足x是u、v的祖先且x的深度尽可能大。”（一个节点也可以是它自己的祖先）
		        _______6______
		       /              \
		    ___2__          ___8__
		   /      \        /      \
		   0      _4       7       9
		         /  \
		         3   5
		例如, 节点 2 和 8的最近公共祖先是 6。再举个例子，节点 2 和 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为指定节点自身。
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
        	return null;
        }
        if(p.val > q.val){
        	return lowestCommonAncestor(root, q, p);
        }
        TreeNode current = root;
        if(root.val >= p.val && root.val <= q.val){
        	return current;
        }
        if(root.val < p.val){
        	return lowestCommonAncestor(root.right, q, p);
        }
    	return lowestCommonAncestor(root.left, q, p);
    }
    
    // 非递归版本
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
        	return null;
        }
        if(p.val > q.val){
        	return lowestCommonAncestor(root, q, p);
        }
        TreeNode current = root;
        while(current != null){
        	if(current.val >= p.val && current.val <= q.val){
        		return current;
        	} else if(current.val < p.val){
        		current = current.right;
        	} else {
        		current = current.left;
        	}
        }
        return null;
    }

}
