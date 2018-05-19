package com.wangfei.leecode;

import java.util.Arrays;

public class MergeArray {

	public static void main(String[] args) {

		int m = 6, n = 6;
		int[] nums1 = {7,8,9,10,11,12,0,0,0,0,0,0};
		int[] nums2 = {1,2,3,7,9,16};
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}
	
	/**
	 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1中，使得 num1 成为一个有序数组。
		注意:
		你可以假设 nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。在 nums1 和 nums2 中初始化的元素的数量分别是 m 和 n。
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	// 学会换位思考，反向思维
    	int k1 = m - 1;
    	int k2 = n - 1;
    	for(int i = m + n - 1; i >=0; i--){
    		if(k1 < 0){
    			nums1[i] = nums2[k2--];
    		}else if(k2 < 0){
    			nums1[i] = nums1[k1--];
    		}else if(nums1[k1] > nums2[k2]){
    			nums1[i] = nums1[k1--];
    		}else{
    			nums1[i] = nums2[k2--];
    		}
    	}
    }

}
