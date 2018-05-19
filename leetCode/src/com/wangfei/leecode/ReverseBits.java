package com.wangfei.leecode;

public class ReverseBits {

	public static void main(String[] args) {
		int n = 43261596;
		System.out.println(Integer.toBinaryString(n));
		
		System.out.println(Integer.toBinaryString(n >> 1));
		ReverseBits rb = new ReverseBits();
		System.out.println(rb.reverseBits(n));

	}
	
    public int reverseBits(int n) {
        int y = 0;
        for(int i = 0; i < 32; i++){
        	y = y << 1;
        	y = y | (n & 1);
        	n = n >> 1;
        }
    	return y;
    }

}
