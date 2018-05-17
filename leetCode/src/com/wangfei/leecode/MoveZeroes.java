package com.wangfei.leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MoveZeroes {

	public static void main(String[] args) {
		MoveZeroes mz = new MoveZeroes();
		int[] nums = {0, 0, 6, 0, 0, 1, 0, 3, 12, 0, 0};
//		int[] nums = {2,1};
		mz.moveZeroes(nums);
		for(int n : nums){
			System.out.print(n + " ");
		}
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		
		Map<String, String> hashMap = new HashMap<String, String>();
	}
	
	/**
	 * 
		给定一个数组 nums, 编写一个函数将所有 0 移动到它的末尾，同时保持非零元素的相对顺序。
		例如， 定义 nums = [0, 1, 0, 3, 12]，调用函数之后， nums 应为 [1, 3, 12, 0, 0]。
		注意事项:
		必须在原数组上操作，不要为一个新数组分配额外空间。
		尽量减少操作总数。
	 * @param nums
	 */
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
        	return;
        }
        int i = 0;
        int index = 0;
        while (i < nums.length){
        	int j = i;
        	while (j < nums.length && nums[j] == 0){
        		j++;
        	}
        	if(index != j && j < nums.length){
        		nums[index] = nums[j];
        		nums[j] = 0;
        	}
        	index++;
        	i = j + 1;
        }
    }
}
