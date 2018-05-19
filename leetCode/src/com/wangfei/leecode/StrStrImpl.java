package com.wangfei.leecode;

public class StrStrImpl {

	public static void main(String[] args) {

//		String haystack = "mississippi";
//		String needle = "issip";
		String haystack = "a";
		String needle = "a";
		System.out.println(strStr1(haystack, needle));
	}
	
	public static int strStr1(String haystack, String needle) {
        if(haystack == null || needle == null){
        	return -1;
        }
        if(needle.isEmpty()){
        	return 0;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len1 < len2){
        	return -1;
        }
        for(int i = 0; i <= len1 - len2; i++){
        	int j = 0;
        	for(; j < len2; j++){
        		if(haystack.charAt(i + j) != needle.charAt(j)){
        			break;
        		}
        	}
        	if(j == len2){
        		return i;
        	}
        }
        return -1;
    }

	/**
	 * 实现 strStr()。
		返回蕴含在 haystack 中的 needle 的第一个字符的索引，如果 needle 不是 haystack 的一部分则返回 -1 。
		
		例 1:
		输入: haystack = "hello", needle = "ll"
		输出: 2
		
		例 2:
		输入: haystack = "aaaaa", needle = "bba"
		输出: -1
	 * @param haystack
	 * @param needle
	 * @return
	 */
    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
        	return -1;
        }
        if(needle.isEmpty()){
        	return 0;
        }
        int removeCount = 0;
        while(haystack.length() > 0){
        	int result = haystack.indexOf(needle.charAt(0));
	        if(result == -1){
	        	return -1;
	        }
	        int j = result + 1;
	        int i = 1;
	        for(; i < needle.length(); i++){
	        	if(j >= haystack.length() || haystack.charAt(j) != needle.charAt(i)){
	        		haystack = haystack.substring(result + 1);
	        		removeCount += result + 1;
	        		break;
	        	}
	        	j++;
	        }
	        if(i == needle.length()){
	        	return result + removeCount;
	        }
        }
    	return -1;
    }
}
