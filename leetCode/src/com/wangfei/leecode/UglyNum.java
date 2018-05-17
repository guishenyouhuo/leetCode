package com.wangfei.leecode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UglyNum {

	public static void main(String[] args) {
		UglyNum un = new UglyNum();
//		System.out.println(Integer.MAX_VALUE / 2);
		for(int i = 0; i < 100; i++){
			System.out.println(i + "->" +un.isUgly1(i));
		}
	}
	
	/**
	 * 编写程序判断给定的数是否为丑数。
		丑数就是只包含质因子 2, 3, 5 的正整数。例如， 6, 8 是丑数，而 14 不是，因为它包含了另外一个质因子 7。
		注意：
		1 也可以被当做丑数。
		输入不会超过32位整数的范围。
	 * @param num
	 * @return
	 */
    public boolean isUgly(int num) {
    	if(num == Integer.MAX_VALUE){
    		return false;
    	}
    	if(num <= 0){
    		return false;
    	}
    	if(num == 5 || num == 3 || num == 2 || num == 1){
    		return true;
    	}
    	return ((num % 2) == 0 && isUgly(num / 2)) || ((num % 3) == 0 && isUgly(num / 3)) || ((num % 5) == 0 && isUgly(num / 5));
    }
    
    // 优化解法
    public boolean isUgly1(int num) {
    	if(num <= 0){
    		return false;
    	}
    	while(num % 5 == 0){
    		num /= 5;
    	}
    	while(num % 3 == 0){
    		num /= 3;
    	}
    	while(num % 2 == 0){
    		num /= 2;
    	}
    	return num == 1;
    }
}
