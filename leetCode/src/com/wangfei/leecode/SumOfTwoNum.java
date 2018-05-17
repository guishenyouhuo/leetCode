package com.wangfei.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.wangfei.utils.SortUtils;

public class SumOfTwoNum {

	public static void main(String[] args) {
//		给定 nums = [2, 7, 11, 15], target = 9
//
//				因为 nums[0] + nums[1] = 2 + 7 = 9
//				所以返回 [0, 1]
		int[] nums = {32,7,11,58,2,15};
//		SortUtils.bubbleSort(nums);
//		SortUtils.insertSort(nums);
//		SortUtils.selectSort(nums);
//		SortUtils.quickSort(nums);
//		System.out.println(Arrays.toString(nums));
		int[] result = twoSum(nums, 9);
		System.out.println(Arrays.toString(result));
	}
	
	
	
	// 两数之和
	public static int[] twoSum(int[] nums, int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result= new int[2];
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int sub = target - num;
			if(map.containsKey(sub) && map.get(sub) != i){
				result[0] = map.get(sub);
				result[1] = i;
				return result;		
			}
			map.put(num, i);
		}
		return result;
	}
	
}
