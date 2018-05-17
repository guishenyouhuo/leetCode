package com.wangfei.leecode;

public class PalindromeStr {

	public static void main(String[] args) {

		String s = "abccccdd";
		PalindromeStr ps = new PalindromeStr();
		System.out.println(ps.longestPalindrome(s));
//		System.out.println(ps.isPalindrome(s));
	}
	
	/**
	 * 给定一个字符串，确定它是否是回文，只考虑字母数字字符和忽略大小写。
		例如：
		"A man, a plan, a canal: Panama" 是回文字符串。
		"race a car" 不是回文字符串。
		注意:
		你有考虑过这个字符串可能是空的吗？ 在面试中这是一个很好的问题。
		针对此题目，我们将空字符串定义为有效的回文字符串。
	 * @param s
	 * @return
	 */
    public boolean isPalindrome(String s) {
        
    	if(s == null || s.length() == 0){
    		return true;
    	}
    	s = s.toLowerCase();
    	int low = 0;
    	int high = s.length() - 1;
    	while(low < high){
    		char lowChar = s.charAt(low);
    		char highChar = s.charAt(high);
    		if(!isChar(lowChar)){
    			++low;
    			continue;
    		}
    		if(!isChar(highChar)){
    			--high;
    			continue;
    		}
    		if(lowChar != highChar && Math.abs(lowChar - highChar) != 32){
    			return false;
    		}
    		++low;
    		--high;
    	}
    	return true;
    }
    
    private boolean isChar(char c){
    	if(c >= '0' && c <= '9'){
    		return true;
    	}
    	if(c >= 'a' && c <= 'z'){
    		return true;
    	}
    	if(c >= 'A' && c <= 'Z'){
    		return true;
    	}
    	return false;
    }
    
    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
		在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
		注意:
		假设字符串的长度不会超过 1010。
		示例 1:
		输入:
		"abccccdd"
		输出:
		7
		解释:
		我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        
    	boolean hasSingle = false;
    	int[] count = new int[54];
    	for(int i = 0; i < s.length(); i++){
    		char c = s.charAt(i);
    		if(c >= 'A' && c <= 'Z'){
    			++count[c - 'A'];
    		} else if(c >= 'a' && c <= 'z'){
    			++count[c - 'a' + 26];
    		}
    	}
    	int result = 0;
    	for(int i = 0; i < count.length; i++){
    		if(count[i] > 0 && (count[i] >> 1) >= 0){
    			result += (count[i] >> 1) << 1;
    			if((count[i] & 1) > 0 && !hasSingle){
    				hasSingle = true;
    			}
    		}
    	}
    	if(hasSingle){
    		++result;
    	}
    	return result;
    }

}
