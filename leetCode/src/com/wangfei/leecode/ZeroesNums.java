package com.wangfei.leecode;

public class ZeroesNums {

	public static void main(String[] args) {
		ZeroesNums zn = new ZeroesNums();
		System.out.println(zn.trailingZeroes(10));
	}
	
    public int trailingZeroes(int n) {
        int num = n / 5;
        int fiveFactors = 0;
        while(num > 0){
        	fiveFactors += num;
        	num = num / 5;
        }
        return fiveFactors;
    }

}
