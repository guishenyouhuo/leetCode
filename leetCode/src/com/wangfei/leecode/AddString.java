package com.wangfei.leecode;

public class AddString {

	public static void main(String[] args) {

		AddString as = new AddString();
		System.out.println(as.addStrings("89", "1991"));
	}
	
	/**
	 * 
		给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
		注意：
		num1 和num2 的长度都小于 5100.
		num1 和num2 都只包含数字 0-9.
		num1 和num2 都不包含任何前导零。
		你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
	 * @param num1
	 * @param num2
	 * @return
	 */
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0){
        	num1 = "0";
        }
        if(num2 == null|| num2.length() == 0){
        	num2 = "0";
        }
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        int len = (num1.length() > num2.length() ? num1.length() : num2.length()) + 1;
        char[] result = new char[len];
        int pos = len - 1;
        int count = 0;
        while(i >= 0 || j >= 0){
        	int n1 = 0, n2 = 0;
        	if(i >= 0){
        		n1 = num1.charAt(i--) - '0';
        	}
        	if(j >= 0){
        		n2 = num2.charAt(j--) - '0';
        	}
        	int sum = n1 + n2 + carry;
        	result[pos--] = (char)(sum % 10 + '0');
        	carry = sum / 10;
        	++count;
        }
        if(carry > 0){
        	result[pos--] = (char)(carry + '0');
        	++count;
        }
    	return String.valueOf(result, pos + 1, count);
    }

}
