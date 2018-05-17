package com.wangfei.leecode;

public class ReverseInt {

	public static void main(String[] args) {

		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
//		int result = reverse(1534236469);
		int result = reverse(-2147483648);
		System.out.println(result);
	}
	public static int reverse(int x) {
		int result = 0;
		int rem = 0;
		while(x != 0){
			rem = x % 10;
			if(result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10){
				return 0;
			}
			result = result * 10 + rem;
			x = x / 10;
		}
		return result;
	}
	public static int reverse1(int x) {
		boolean negativeFlag = false;
		if(x < 0){
			x = 0 - x;
			negativeFlag = true;
		}
		StringBuilder sb = new StringBuilder();
		while(x > 0){
			int mod = x % 10;
			sb.append(mod);
			x = x / 10;
		}
		if(sb.length() == 0){
			return 0;
		}
		String maxValue = String.valueOf(Integer.MAX_VALUE);
		if(maxValue.length() < sb.length() || 
				(maxValue.length() == sb.length() && maxValue.compareTo(sb.toString()) < 0)){
			return 0;
		}
		int result = Integer.parseInt(sb.toString());
		if(negativeFlag){
			result = 0 - result;
		}
        return result;
    }

}
