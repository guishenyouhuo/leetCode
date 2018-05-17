package com.wangfei.leecode;

public class FindNthDigit {

	public static void main(String[] args) {
		
		FindNthDigit fnd = new FindNthDigit();
		System.out.println(fnd.findNthDigit(14));
	}
	
	/**
	 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
		注意:
		n 是正数且在32为整形范围内 ( n < 2的31次)。
		示例 1:
		输入:
		3
		输出:
		3
		示例 2:
		输入:
		11
		输出:
		0
		说明:
		第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
	 * @param n
	 * @return
	 */
    public int findNthDigit(int n) {
        long len = 1, cnt = 9, start = 1;
        while(n > len * cnt){
        	n -= len * cnt;
        	++len;
        	cnt *= 10;
        	start *= 10;
        }
        start += (n - 1) / len;
    	return String.valueOf(start).charAt((int)((n - 1) % len)) - '0';
    }
}
