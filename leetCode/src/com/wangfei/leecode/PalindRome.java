package com.wangfei.leecode;

public class PalindRome {

	public static void main(String[] args) {
		boolean result = isPalindrome3(12321);
		System.out.println(result);
		
//		int x = 1000;
//		int len = 1;
//		while(x / len >= 10){
//			len *= 10;
//		}
//		System.out.println(len);
	}
	public static boolean isPalindrome3(int x){
		if(x < 0){
			return false;
		}
		int result = 0;
		int rem = 0;
		while(result < x){
			rem = x % 10;
			if(result > Integer.MAX_VALUE / 10){
				return false;
			}
			result = result * 10 + rem;
			if(result == x){
				return true;
			}
			x = x / 10;
		}
		return result == x;
	}
	public static boolean isPalindrome2(int x){
		if(x < 0){
			return false;
		}
		int len = 1;
		while(x / len >= 10){
			len *= 10;
		}
		while(x > 0){
			int first = x / len;
			int last = x % 10;
			if(first != last){
				return false;
			}
			x = (x % len) / 10;
			len /= 100;
		}
		return true;
	}
	public static boolean isPalindrome(int x) {
		int backUp = x;
		if(x < 0){
			return false;
		}
		int result = 0;
		int rem = 0;
		while(x != 0){
			rem = x % 10;
			if(result > Integer.MAX_VALUE / 10){
				return false;
			}
			result = result * 10 + rem;
			x = x / 10;
		}
		return backUp == result;
    }

}
