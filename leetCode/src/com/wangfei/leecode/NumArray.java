package com.wangfei.leecode;

public class NumArray {

	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		NumArray na = new NumArray(nums);
		System.out.println(na.sumRange(0, 5));
	}
	
	private int[] dp;
    public NumArray(int[] nums) {
        dp = nums;
        for(int i = 1; i < nums.length; i++){
        	dp[i] += dp[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
    	return i == 0 ? dp[j] : dp[j] - dp[i - 1];
    }

}
