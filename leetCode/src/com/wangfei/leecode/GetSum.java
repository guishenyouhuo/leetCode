package com.wangfei.leecode;

public class GetSum {

	public static void main(String[] args) {

		GetSum gs = new GetSum();
		System.out.println(gs.getSum(11, 25));
	}
	
	/**
	 * 
		不使用运算符 + 和-，计算两整数a 、b之和。
		示例：
		若 a = 1 ，b = 2，返回 3。
	 * @param a
	 * @param b
	 * @return
	 */
    public int getSum(int a, int b) {
        if(b == 0){
        	return a; 
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
    	return getSum(sum, carry);
    }

}
