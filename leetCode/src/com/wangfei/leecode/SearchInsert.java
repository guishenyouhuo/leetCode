package com.wangfei.leecode;

public class SearchInsert {

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 2;
		System.out.println(searchInsert(nums, target));

	}

	/**
	 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
		你可以假设在数组中无重复元素。
		
		案例 1:
		输入: [1,3,5,6], 5
		输出: 2
		
		案例 2:
		输入: [1,3,5,6], 2
		输出: 1
		
		案例 3:
		输入: [1,3,5,6], 7
		输出: 4
		 
		案例 4:
		输入: [1,3,5,6], 0
		输出: 0
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int searchInsert(int[] nums, int target) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
        	int middle = (low + high) / 2;
        	if(target < nums[middle]){
        		high = middle - 1;
        	} else if(target > nums[middle]){
        		low = middle + 1;
        	} else{
        		return middle;
        	}
        }
        if(target <= nums[0]){
        	return 0;
        }
        if(target > nums[nums.length - 1]){
        	return nums.length;
        }
    	return target < nums[low] ? low : low + 1;
    }
}
