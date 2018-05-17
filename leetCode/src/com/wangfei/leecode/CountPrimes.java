package com.wangfei.leecode;

import java.util.Arrays;

public class CountPrimes {

	public static void main(String[] args) {

		CountPrimes cp = new CountPrimes();
		System.out.println(cp.countPrimes1(999983));
	}
	
	/**
	 * 筛选法
	 * @param n
	 * @return
	 */
	public int countPrimes1(int n) {
		boolean[] prime = new boolean[n];
		Arrays.fill(prime, true);
		for(int i = 2; i < n; i++){
			if(prime[i]){
				for(int j = i * 2; j < n; j = j + i){
					prime[j] = false;
				}
			}
		}
		int count = 0;
		for(int i = 2; i < prime.length; i++){
			if(prime[i]){
				++count;
			}
		}
		return count;
	}

	/**
	 * 计算所有小于非负数整数 n 的质数数量。
	 * @param n
	 * @return
	 */
    public int countPrimes(int n) {
        int count = 0;
        for(int i = 2; i < n; i++){
        	if(isPrime(i)){
        		++count;
        	}
        }
    	return count;
    }
    private boolean isPrime(int num){
    	if(num <= 1){
    		return false;
    	}
    	for(int i = 2; i * i <= num; i++){
    		if(num % i == 0){
    			return false;
    		}
    	}
    	return true;
    }
}
