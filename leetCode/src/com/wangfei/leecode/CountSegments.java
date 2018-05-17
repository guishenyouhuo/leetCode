package com.wangfei.leecode;

public class CountSegments {

	public static void main(String[] args) {

		CountSegments cs = new CountSegments();
		System.out.println(cs.countSegments("   Hello, my name is John   "));
	}
	
	/**
	 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
		请注意，你可以假定字符串里不包括任何不可打印的字符。
		示例:
		输入: "Hello, my name is John"
		输出: 5
	 * @param s
	 * @return
	 */
    public int countSegments(String s) {
        if(s == null | s.length() == 0){
        	return 0;
        }
        int end = s.length() - 1;
        int start = 0;
        int result = 0;
        while(start <= end){
        	while(start <= end && s.charAt(start) == ' '){
        		++start;
        	}
        	if(start <= end){
        		++result;
        	}
        	while(start <= end && s.charAt(start) != ' '){
        		++start;
        	}
        }
    	return result;
    }

}
