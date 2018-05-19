package com.wangfei.leecode;

public class AddBinary {

	public static void main(String[] args) {

//		System.out.println(('1' - '0' + '1' - '0'));
//		StringBuilder sb = new StringBuilder();
//		sb.insert(0, 1);
//		sb.insert(0, 2);
//		sb.insert(0, 3);
//		System.out.println(sb.toString());
		String a = "1";
		String b = "1";
		System.out.println(addBinary(a, b));
	}
	
	/**
	 * 给定两个二进制字符串，返回他们的和（用二进制表示）。

		案例：
		a = "11"
		b = "11"
		返回 "100" 。
	 * @param a
	 * @param b
	 * @return
	 */
    public static String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if(lenA > lenB){
        	return addBinary(b, a);
        }
        int i = lenA - 1;
        int j = lenB - 1;
        int ahead = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
        	int sumi = 0;
        	if(i >= 0){
        		sumi = a.charAt(i--) - '0';
        	}
        	int sumj = sumi + b.charAt(j--) - '0';
        	int resj = sumj + ahead;
        	int res = resj;
        	ahead = 0;
        	if(resj > 1){
        		res = resj % 2;
        		ahead = resj / 2;
        	}
        	sb.insert(0, res);
        }
        if(ahead > 0){
        	sb.insert(0, ahead);
        }
    	return sb.toString();
    }

}
