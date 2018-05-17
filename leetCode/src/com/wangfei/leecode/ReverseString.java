package com.wangfei.leecode;

public class ReverseString {

	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		System.out.println(rs.reverseVowels("leetcode"));

	}
	
    public String reverseString(String s) {
    	if(s == null){
    		return null;
    	}
    	if(s.length() <= 1){
    		return s;
    	}
    	char[] charArray = s.toCharArray();
    	int low = 0;
    	int high = charArray.length - 1;
    	while (low < high){
    		char tmp = charArray[low];
    		charArray[low] = charArray[high];
    		charArray[high] = tmp;
    		++low;
    		--high;
    	}
    	return String.valueOf(charArray);
    }
    
    public String reverseVowels(String s) {
    	if(s == null){
    		return null;
    	}
    	if(s.length() <= 1){
    		return s;
    	}
    	char[] charArray = s.toCharArray();
    	int low = 0;
    	int high = charArray.length - 1;
    	while (low < high){
    		if(!isVowel(charArray[low])){
    			++low;
    			continue;
    		}
    		if(!isVowel(charArray[high])){
    			--high;
    			continue;
    		}
    		char tmp = charArray[low];
    		charArray[low] = charArray[high];
    		charArray[high] = tmp;
    		++low;
    		--high;
    	}
    	return String.valueOf(charArray);
    }
    private boolean isVowel(char c){
    	if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
    		return true;
    	}
    	if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
    		return true;
    	}
    	return false;
    }

}
