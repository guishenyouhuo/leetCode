package com.wangfei.leecode;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		int[] digits = {9,9,9,9};
		System.out.println(Arrays.toString(plusOne(digits)));

	}
	
	/**
	 * 给定一个非负整数组成的非空数组，给整数加一。
		可以假设整数不包含任何前导零，除了数字0本身。
		最高位数字存放在列表的首位。
	 * @param digits
	 * @return
	 */
    public static int[] plusOne(int[] digits) {
    	int i = digits.length - 1;
    	while(i >= 0 && digits[i] == 9){
    		digits[i--] = 0;
    	}
    	if(i == -1){
    		int[] result = new int[digits.length + 1];
    		result[0] = 1;
    		return result;
    	}
    	digits[i] += 1;
    	return digits;
    }

}
