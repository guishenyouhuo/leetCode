package com.wangfei.leecode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {

		MajorityElement me = new MajorityElement();
		int[] nums = {1,2,1,3,1};
		System.out.println(me.majorityElement(nums));
		
	}
	
	/**
	 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
		你可以假设数组是非空的，并且数组中的众数永远存在。
	 * @param nums
	 * @return
	 */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
        	Integer count = map.get(nums[i]);
        	if(count == null){
        		count = 0;
        	}
        	++count;
        	if(count > nums.length / 2){
        		return nums[i];
        	}
        	map.put(nums[i], count);
        }
    	return 0;
    }

}
