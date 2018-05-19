package com.wangfei.leecode;

public class CountAndSay {

	public static void main(String[] args) {
		for(int i = 1; i <= 30; i++){
			System.out.println(countAndSayDp(i));
		}
		System.out.println(countAndSayDp(4));

	}
	
	public static String countAndSayDp(int n) {
        if(n == 1){
        	return "1";
        }
        String previous = "1";
        for(int i = 2; i <= n; i++){
        	int k = 0;
        	StringBuilder sb = new StringBuilder();
        	while(k < previous.length()){
	        	int j = k + 1;
	        	while(j < previous.length() && previous.charAt(k) == previous.charAt(j)){
	        		j++;
	        	}
	        	sb.append(j - k).append(previous.charAt(k));
	        	k = j;
        	}
        	previous = sb.toString();
        }
    	return previous;
    }

	/**
	 * 数数并说序列是一个整数序列，第二项起每一项的值为对前一项的计数，其前五项如下：
		1.     1
		2.     11
		3.     21
		4.     1211
		5.     111221
		1 被读作 "一个一" 即 11。
		11 被读作  "两个一" 即 21。
		21 被读作  "一个二 和 一个一" 即 1211。
		给一个正整数 n ，输出数数并说序列的第 n 项。
		注意：该整数序列的每项都输出为字符串。
		
		例 1:
		输入: 1
		输出: "1"
		
		例 2:
		输入: 4
		输出: "1211"
	 * @param n
	 * @return
	 */
    public static String countAndSay(int n) {
        if(n == 1){
        	return "1";
        }
        String previous = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < previous.length()){
        	int j = i + 1;
        	while(j < previous.length() && previous.charAt(i) == previous.charAt(j)){
        		j++;
        	}
        	sb.append(j - i).append(previous.charAt(i));
        	i = j;
        }
    	return sb.toString();
    }
}
