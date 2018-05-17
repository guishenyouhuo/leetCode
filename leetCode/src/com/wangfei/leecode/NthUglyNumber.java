package com.wangfei.leecode;

public class NthUglyNumber {

	public static void main(String[] args) {

		NthUglyNumber nun = new NthUglyNumber();
		System.out.println(nun.nthUglyNumber(100));
	}

	/**
	 * 编写程序找第 n 个丑数。
		丑数就是只包含质因子 2, 3, 5 的正整数。
		例如， 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 就是前10个丑数。
		注意:
		1. 1 一般也被当做丑数
		2. n不超过1690
	 * @param n
	 * @return
	 */
    public int nthUglyNumber(int n) {
    	int[] uglyNums = new int[n];
    	uglyNums[0] = 1;
    	int idx2 = 0;
    	int idx3 = 0;
    	int idx5 = 0;
    	int count = 1;
    	while(count < n){
    		int tmpMin = Math.min(uglyNums[idx2] * 2, uglyNums[idx3] * 3);
    		int min = Math.min(tmpMin, uglyNums[idx5] * 5);
    		if(min == uglyNums[idx2] * 2){
    			++idx2;
    		}
    		if(min == uglyNums[idx3] * 3){
    			++idx3;
    		}
    		if(min == uglyNums[idx5] * 5){
    			++idx5;
    		}
    		uglyNums[count++] = min;
    	}
    	return uglyNums[n - 1];
    }
}
