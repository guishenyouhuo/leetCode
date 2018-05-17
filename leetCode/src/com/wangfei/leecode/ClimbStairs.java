package com.wangfei.leecode;

public class ClimbStairs {

	public static void main(String[] args) {

		System.out.println(climbStairs(8));
	}
	
	/**
	 * 你正在爬楼梯。需要 n 步你才能到达顶部。
		每次你可以爬 1 或 2 个台阶。你有多少种不同的方式可以爬到楼顶呢？
		注意：给定 n 将是一个正整数。
		
		示例 1：
		输入： 2
		输出： 2
		说明： 有两种方法可以爬到顶端。
		1.  1 步 + 1 步
		2.  2 步
		f(n - 1) + f(n - 2)
		示例 2：
		输入： 3
		输出： 3
		说明： 有三种方法可以爬到顶端。
		1.  1 步 + 1 步 + 1 步
		2.  1 步 + 2 步
		3.  2 步 + 1 步
	 * @param n
	 * @return
	 */
    public static int climbStairs(int n) {
    	
    	int one = 0;
    	int two = 1;
    	int result = two;
    	for(int i = 1; i <= n; i++){
    		result = one + two;
    		one = two;
    		two = result;
    	}
        return result;
    }
    private static int func(int n){
    	if(n < 3){
    		return n;
    	}
    	return func(n - 1) + func(n - 2);
    }

}
