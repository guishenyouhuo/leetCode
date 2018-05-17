package com.wangfei.leecode;

public class PerfectSquare {

	public static void main(String[] args) {

		PerfectSquare ps = new PerfectSquare();
		System.out.println(ps.isPerfectSquare(64));
	}
	
	/**
	 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
		注意：不要使用任何内置的库函数，如  sqrt。
		示例 1：
		输入： 16
		输出： True
		示例 2：
		输入： 14
		输出： False
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
        for(int i = 1; num > 0; i += 2){
        	num -= i;
        }
    	return num == 0;
    }
    public boolean isPerfectSquare1(int num) {
        if(num == 1){
        	return true;
        }
        int half = num >> 1;
        if(half < 1){
        	return false;
        }
        for(int i = half; i >= 1; i--){
        	if(num % i == 0 && num / i == i){
        		return true;
        	}
        }
    	return false;
    }

}
