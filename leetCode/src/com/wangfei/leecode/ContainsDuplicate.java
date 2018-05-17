package com.wangfei.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {

		int[] nums = {1,2,3,2};
		ContainsDuplicate cd = new ContainsDuplicate();
//		System.out.println(cd.containsDuplicate(nums));
		System.out.println(cd.containsNearbyDuplicate(nums, 1));
	}
	
	/**
	 * 
		给定一个整数数组，判断是否存在重复元素。
		如果任何值在数组中出现至少两次，函数应该返回 true。如果每个元素都不相同，则返回 false。
	 * @param nums
	 * @return
	 */
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
        	return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
        	if(!set.add(nums[i])){
        		return true;
        	}
        }
    	return false;
    }
    
    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使 nums [i] = nums [j]，并且 i 和 j 的绝对差值最大为 k。
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
        	return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
        	Integer index = map.get(nums[i]);
        	if(index != null && i - index <= k){
        		return true;
        	}
        	map.put(nums[i], i);
        }
    	return false;
    }

}
