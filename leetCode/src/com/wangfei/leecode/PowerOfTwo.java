package com.wangfei.leecode;

public class PowerOfTwo {

	public static void main(String[] args) {

		PowerOfTwo pot = new PowerOfTwo();
		
//		System.out.println(Integer.toBinaryString(-16));
//		System.out.println(Integer.toBinaryString(-1));
//		System.out.println((-32)^(-1));
		System.out.println(pot.isPowerOfFour(128));
//		System.out.println(Math.pow(2, 31));
//		System.out.println(Math.pow(-2, 5));
	}
	/**
	 * 给定一个整数，写一个函数来判断它是否是2的幂。
	 * @param n
	 * @return
	 */
    public boolean isPowerOfTwo(int n) {
    	int oneCount = 0;
        while(n != 0){
        	if((n & 1) != 0){
        		++oneCount;
        	}
        	if(oneCount > 1){
        		return false;
        	}
        	n >>= 1;
        }
    	return oneCount == 1;
    }
    
    /**
     * 给出一个整数，写一个函数来确定这个数是不是3的一个幂。
		后续挑战：
		你能不使用循环或者递归完成本题吗？
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
    	return (n > 0 && 1162261467 % n == 0);
    }
    
    /**
     * 给定一个整数 (32位有符整数型)，请写出一个函数来检验它是否是4的幂。
		示例:
		当 num = 16 时 ，返回 true 。 当 num = 5时，返回 false。
		问题进阶：你能不使用循环/递归来解决这个问题吗？
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
    	
    	return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xAAAAAAAA) == 0);
    }

}
