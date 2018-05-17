package com.wangfei.leecode;

public class MySqrt {

	public static void main(String[] args) {

		System.out.println(Integer.MAX_VALUE);
		System.out.println(mySqrt(Integer.MAX_VALUE));
		System.out.println(mySqrt(Integer.MAX_VALUE) * mySqrt(Integer.MAX_VALUE));
	}
	
	/**
	 * 实现 int sqrt(int x) 函数。
		计算并返回 x 的平方根。
		x 保证是一个非负整数。
		
		案例 1:
		输入: 4
		输出: 2
		
		案例 2:
		输入: 8
		输出: 2
		说明: 8 的平方根是 2.82842..., 由于我们想返回一个整数，小数部分将被舍去。
	 * @param x
	 * @return
	 */
    public static int mySqrt(int x) {
        // 前提:x的平方根小于x/2+1
    	long i = 0;
    	long j = x / 2 + 1;
    	while(i <= j){
    		long mid = (i + j) / 2;
    		long sq = mid * mid;
    		if(sq == x) return (int) mid;
    		else if(sq < x) i = mid + 1;
    		else j = mid - 1;
    	}
    	return (int) j;
    }

}
