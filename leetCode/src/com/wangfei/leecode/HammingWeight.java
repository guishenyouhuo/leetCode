package com.wangfei.leecode;

public class HammingWeight {

	public static void main(String[] args) {

		HammingWeight hw = new HammingWeight();
//		int n = Integer.valueOf("10000000000000000000000000000000", 2);
//		long l = 4294967295l;
		System.out.println(Integer.toBinaryString(0xFFFFFFFF));
		System.out.println((-1) & 0xFFFFFFFF);
		System.out.println(hw.hammingWeight(0xFFFFFFFF));
	}
	
    public int hammingWeight(int n) {
    	int result = 0;
        while(n != 0){
        	++result;
        	n = n & (n - 1);
        }
    	return result;
    }

}
