package com.wangfei.leecode;

public class ThirdMax {

	public static void main(String[] args) {

		ThirdMax tm = new ThirdMax();
		int[] nums = {2, 3, 1};
		System.out.println(tm.thirdMax(nums));
	}
	
	/**
	 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
		示例 1:
		输入: [3, 2, 1]
		输出: 1
		解释: 第三大的数是 1.
		示例 2:
		输入: [1, 2]
		输出: 2
		解释: 第三大的数不存在, 所以返回最大的数 2 .
		示例 3:
		输入: [2, 2, 3, 1]
		输出: 1
		解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
		存在两个值为2的数，它们都排第二。
	 * @param nums
	 * @return
	 */
	 public int thirdMax(int[] nums) {
    	long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
    	for(int i = 0; i < nums.length; i++){
    		if(nums[i] > first){
    			third = second;
    			second = first;
    			first = nums[i];
    		} else if(nums[i] < first && nums[i] > second){
    			third = second;
    			second = nums[i];
    		} else if(nums[i] < second && nums[i] > third){
    			third = nums[i];
    		}
    	}
    	return (int)(third == Long.MIN_VALUE || third == second ? first : third);
    }


    public int thirdMax1(int[] nums) {
    	int len = nums.length;
    	int[] maxFour = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    	int k = 0;
    	for(int i = len; i > 0; i--){
    		int halfLen = (i - 2) >> 1;
    		for(int j = halfLen; j >= 0; j--){
    			int cur = nums[j];
    			int leftIdx = 2 * j + 1;
    			if(leftIdx + 1 <= i - 1 && nums[leftIdx + 1] > nums[leftIdx]){
    				++leftIdx;
    			}
    			if(nums[leftIdx] > nums[j]){
    				nums[j] = nums[leftIdx];
    				nums[leftIdx] = cur;
    			}
    		}
    		if(k == 0 || nums[0] != maxFour[k - 1]){
    			maxFour[k++] = nums[0];
    		}
    		if(k > 3){
    			break;
    		}
    		int temp = nums[0];
    		nums[0] = nums[i - 1];
    		nums[i - 1] = temp;
    	}
    	if(maxFour[2] == maxFour[3]){
    		return maxFour[0];
    	}
    	return maxFour[2];
    }

}
