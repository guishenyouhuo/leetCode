package com.wangfei.leecode;

public class CrossBridgeDp {

	public static void main(String[] args) {
		int[] nums = {1, 2, 5, 10};

		System.out.println(minTimeDp(nums));
	}
	public static int minTimeDp(int[] nums){
		
		int[] m = new int[nums.length + 1];
		for(int i = 0; i < m.length; i++){
			m[i] = -1;
		}
		
		return calcute(nums, nums.length, m);
	}
	public static int calcute(int[] nums, int n, int[] m){
		if(n == 0){
			m[0] = 0;
			return 0;
		}
		if(n <= 2){
			m[n] = nums[n - 1];
			return m[n];
		}
		if(m[n] > 0){
			return m[n]; 
		}
//		for(int i = 2; i <= n; i++){
//			int optOne = m[i-1] + nums[0] + nums[i - 1];
//			int optTwo = m[i-2] + nums[0] + nums[i - 1] + 2 * nums[1];
//			m[i] = Math.min(optOne, optTwo);
//		}
		int optOne =calcute(nums, n - 1, m) + nums[0] + nums[n - 1];
		int optTwo = calcute(nums, n - 2, m) + nums[0] + nums[n - 1] + 2 * nums[1];
		m[n] = Math.min(optOne, optTwo);
		return m[n];
	}

}
