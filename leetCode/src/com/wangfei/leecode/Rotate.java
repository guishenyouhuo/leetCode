package com.wangfei.leecode;

public class Rotate {

	public static void main(String[] args) {

		int[] nums = {1,2,3,4,5,6,7};
		Rotate rt = new Rotate();
		rt.rotate1(nums, 3);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	// 优化
	public void rotate1(int[] nums, int k) {
		if(k == 0){
    		return;
    	}
    	if(nums == null || nums.length <= 1){
    		return;
    	}
    	int split = k % nums.length;
    	reverse(nums, 0, nums.length - 1 - split);
    	reverse(nums, nums.length - split, nums.length - 1);
    	reverse(nums, 0, nums.length - 1);
    	
	}
	
	private void reverse(int[] nums, int start, int end){
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			++start;
			--end;
		}
	}
	
    public void rotate(int[] nums, int k) {
    	if(k == 0){
    		return;
    	}
    	if(nums == null || nums.length <= 1){
    		return;
    	}
        while(k-- > 0){
        	int lastNum = nums[nums.length - 1];
        	for(int i = nums.length - 2; i >= 0; i--){
        		nums[i + 1] = nums[i];
        	}
        	nums[0] = lastNum;
        }
    }

}
