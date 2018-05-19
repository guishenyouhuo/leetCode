package com.wangfei.leecode;

public class Rob {

	public static void main(String[] args) {
		Rob r = new Rob();
		int[] nums = {2,3,2,2};
		System.out.println(r.rob(nums));
	}
	
    public int rob(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	int robLast = nums[0];
    	int passLast = 0;
    	int robCur = 0, passCur = 0;
    	for(int i = 1; i < nums.length; i++){
    		robCur = nums[i] + passLast;
    		passCur = Math.max(robLast, passLast);
    		passLast = passCur;
    		robLast = robCur;
    	}
        return Math.max(passLast, robLast);
    }

}
