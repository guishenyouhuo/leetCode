package com.wangfei.utils;

public class BaseCalculate {

	public static void main(String[] args) {
		System.out.println(add(105, 714));
		System.out.println(sub(105, 714));
		
		System.out.println(mul(25, 25));
	}
	
	/**
	 * 加法
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a, int b){
		int sum = 0;
		while(b != 0){
			sum = a ^ b;
			int carry = (a & b) << 1;
			a = sum;
			b = carry;
		}
		return sum;
	}
	
	/**
	 * 减法
	 * @param a
	 * @param b
	 * @return
	 */
	public static int sub(int a, int b){
		return add(a, negative(b));
	}
	/**
	 * 求负数
	 * @param a
	 * @return
	 */
	public static int negative(int a){
		return add(~a, 1);
	}
	
	public static int mul(int a, int b){
		int ans = 0;
		while(b > 0){
			if((b & 1) > 0){
				ans = add(ans, a);
			}
			a <<= 1;
			b >>= 1;
		}
		return ans;
	}

}
