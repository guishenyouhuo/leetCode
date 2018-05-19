package com.wangfei.leecode;

public class MedianNum {

	public static void main(String[] args) {
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		System.out.println(findMedianSortedArrays2(nums1, nums2));

	}
	
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2){
		int len1 = nums1.length;
		int len2 = nums2.length;
		int size = len1 + len2;
		if((size % 2) == 1){
			return findKTh(nums1, 0, nums2, 0, size / 2 + 1);
		} else {
			return (findKTh(nums1, 0, nums2, 0, size / 2) + findKTh(nums1, 0, nums2, 0, size / 2 + 1)) / 2.0;
		}
	}
	
	public static double findKTh(int[] nums1, int start1, int[] nums2, int start2, int k){
		int len1 = nums1.length;
		int len2 = nums2.length;
		if((len1 - start1) > (len2 - start2)){
			return findKTh(nums2, start2, nums1, start1, k);
		}
		if(len1 - start1 == 0){
			return nums2[k - 1];
		}
		if(k == 1){
			return Math.min(nums1[start1], nums2[start2]);
		}
		int p1 = start1 +  Math.min(k / 2, len1 - start1);
		int p2 = start1 + start2 - p1 + k;
		if(nums1[p1 - 1] < nums2[p2 - 1]){
			return findKTh(nums1, p1, nums2, start2, k - p1 + start1);
		} else if(nums1[p1 - 1] > nums2[p2 - 1]){
			return findKTh(nums1, start1, nums2, p2, k - p2 + start2);
		}else{
			return nums1[p1 - 1];
		}
	}
	
	// 最优版本
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(m < n){
        	return findMedianSortedArrays(nums2, nums1);
        }
        int l1 = 0, l2 = 0, r1 = 0, r2 = 0, c1, c2 = 0;
        int lo = 0;
        int hi = 2 * n;
        while(lo <= hi){
        	c1 = (lo + hi) / 2;
        	c2 = m + n - c1;
        	l1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
        	r1 = (c1 == 2 * n) ? Integer.MAX_VALUE : nums1[c1 / 2];
        	l2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
        	r2 = (c2 == 2 * m) ? Integer.MAX_VALUE : nums2[c2 / 2];
        	if(l1 > r2){
        		hi = c1 - 1;
        	} else if (l2 > r1){
        		lo = c1 + 1;
        	} else {
        		break;
        	}
        }
        return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
    }

}
