package com.wangfei.leecode;

public class LenOfLastWord {

	public static void main(String[] args) {
		String s = " Hellosa World";
		System.out.println(lengthOfLastWord2(s));

	}
	
	public static int lengthOfLastWord2(String s) {
        int i = s.length() - 1;
        int end = i;
        while(i >= 0){
        	// 处理多空格的问题
        	while(i >= 0 && s.charAt(i) == ' '){
        		--i;
        	}
        	end = i;
        	while (i >= 0 && ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || 
        			(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))){
        		--i;
        	} 
        	if((i >= 0 && s.charAt(i) == ' ') || i == -1){
        		return end - i;
        	}
        	// 遇到不是单词的情况需要找出前面一个单词
        	while(i >= 0 && s.charAt(i) != ' '){
        		--i;
        	}
        }
    	return 0;
    }
	
	
	/**
	 * 给定一个字符串， 包含大小写字母、空格 ' '，请返回其最后一个单词的长度。
		如果不存在最后一个单词，请返回 0 。
		注意事项：一个单词的界定是，由字母组成，但不包含任何的空格。
		
		案例:
		输入: "Hello World"
		输出: 5
	 * @param s
	 * @return
	 */
    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while(i >= 0 && s.charAt(i) == ' '){
    		--i;
    	}
        int end = i;
        while(i >= 0){
        	char charAtI = s.charAt(i);
        	if((charAtI >= 'A' && charAtI <= 'Z') || 
        			(charAtI >= 'a' && charAtI <= 'z')){
        		i--;
        		continue;
        	} 
        	if(charAtI == ' '){
        		return end - i;
        	}
        	// 遇到不是单词的情况需要找出前面一个单词
        	while(i >= 0 && s.charAt(i) != ' '){
        		--i;
        	}
        	// 处理多空格的问题
        	while(i >= 0 && s.charAt(i) == ' '){
        		--i;
        	}
        	end = i;
        }
    	return end - i;
    }

}
