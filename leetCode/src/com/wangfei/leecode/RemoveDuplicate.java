package com.wangfei.leecode;

import java.util.Arrays;

public class RemoveDuplicate {

	public static void main(String[] args) {
		int[] nums = {1,2,2,2,3,4,5,5,6,7,7,7,8,9};
//		int[] nums = {1,2,2};
		System.out.println(Arrays.toString(nums));
		System.out.println(removeDuplicates1(nums));
		System.out.println(Arrays.toString(nums));

	}
	
	
	
	// 优化版本
	public static int removeDuplicates1(int[] nums) {
		if(nums == null){
			return 0;
		}
		if(nums.length <= 1){
			return nums.length;
		}
		int number = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[number] != nums[i]){
				nums[++number] = nums[i];
			}
		}
		return number + 1;
    }
	
	
	/**
	 * 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
		不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
		
		示例：
		给定数组: nums = [1,1,2],
		你的函数应该返回新长度 2, 并且原数组nums的前两个元素必须是1和2
		不需要理会新的数组长度后面的元素
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		if(nums == null){
			return 0;
		}
		if(nums.length <= 1){
			return nums.length;
		}
		int repeatCount = 0;
		int totalRepeat = 0;
		int startIndex = 0;
		for(int i = 0; i < nums.length - 1; i++){
			if(nums[i + 1] == nums[i] && repeatCount == 0){
				++repeatCount;
				++totalRepeat;
				startIndex = i + 1;
				continue;
			}
			if((nums[i + 1] == nums[i] && repeatCount > 0) ){
				for(int j = startIndex + 1; j <= i; j++){
					nums[j - totalRepeat] = nums[j];
				}
				repeatCount = 0;
				i--;
			}
		}
		for(int j = startIndex + 1; j < nums.length; j++){
			nums[j - totalRepeat] = nums[j];
		}
        return nums.length - totalRepeat;
    }

}
