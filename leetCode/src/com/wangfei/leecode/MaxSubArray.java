package com.wangfei.leecode;

public class MaxSubArray {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArrayDp2(nums));

	}
	
	
	// 动态规划优化
	public static int maxSubArrayDp2(int[] nums) {
    	int max = nums[0];
    	int maxSum = nums[0];
    	for (int i = 1; i < nums.length; i++) {
			maxSum = maxSum > 0 ? maxSum + nums[i] : nums[i];
			max = Math.max(max, maxSum);
		}
    	return max;
    }
	
	// 动态规划
	public static int maxSubArrayDp(int[] nums) {
    	int max = nums[0];
    	int[] maxSum = new int[nums.length];
    	maxSum[0] = nums[0];
    	for (int i = 1; i < nums.length; i++) {
    		maxSum[i] = nums[i];
			if(maxSum[i - 1] > 0){
				maxSum[i] += maxSum[i - 1];
			}
			max = Math.max(max, maxSum[i]);
		}
    	return max;
    }
	
	/**
	 * 给定一个序列（至少含有 1 个数），从该序列中寻找一个连续的子序列，使得子序列的和最大。
		例如，给定序列 [-2,1,-3,4,-1,2,1,-5,4]，
		连续子序列 [4,-1,2,1] 的和最大，为 6。
		
		扩展练习:
		若你已实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
	 * @param nums
	 * @return
	 */
	// 暴力破解法
    public static int maxSubArray(int[] nums) {
    	if(nums.length == 1){
    		return nums[0];
    	}
    	int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
        	int sum = nums[i];
        	if(sum > result){
    			result = sum;
    		}
        	for(int j = i + 1; j < nums.length; j++){
        		sum += nums[j];
        		if(sum > result){
        			result = sum;
        		}
        	}
        }
    	return result;
    }

}
