package com.wangfei.leecode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {

	public static void main(String[] args) {

		int[] numbers = {2, 7, 11, 15};
		TwoSum2 ts = new TwoSum2();
		int[] result = ts.twoSum1(numbers, 13);
		System.out.println(result == null ? "null" : result[0] + ", " + result[1]);
	}
	
	/**
	 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
		函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。请注意，返回的下标值（index1 和 index2）不是从零开始的。
		你可以假设每个输入都只有一个解决方案，而且你不会重复使用相同的元素。
		输入：数组 = {2, 7, 11, 15}, 目标数 = 9
		输出：index1 = 1, index2 = 2
	 * @param numbers
	 * @param target
	 * @return
	 */
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0){
        	return null;
        }
        int low = 0;
        int high = numbers.length - 1;
        while(low < high){
        	if(numbers[low] + numbers[high] == target){
        		return new int[]{low + 1, high + 1};
        	}
        	if(numbers[low] + numbers[high] < target){
        		++low;
        		continue;
        	}
        	if(numbers[low] + numbers[high] > target){
        		--high;
        		continue;
        	}
        }
    	return null;
    }
    
    // 版本2
    public int[] twoSum2(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0){
        	return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){
        	int sub = target - numbers[i];
        	Integer index = map.get(sub);
        	if(index != null){
        		return new int[]{index + 1, i + 1};
        	}
        	map.put(numbers[i], i);
        }
    	return null;
    }
    
    // 非排序版本
    public int[] twoSum1(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0){
        	return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){
        	int sub = target - numbers[i];
        	Integer index = map.get(sub);
        	if(index != null){
        		return new int[]{index + 1, i + 1};
        	}
        	map.put(numbers[i], i);
        }
    	return null;
    }

}
