package com.wangfei.leecode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	public static void main(String[] args) {
		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern1("abba", "dog dog dog dog"));

	}
	
	// 优化版本
	public boolean wordPattern1(String pattern, String str) {
        
    	if(pattern == null || pattern.length() == 0){
    		return false;
    	}
    	if(str == null || str.length() == 0){
    		return false;
    	}
    	String[] strArr = str.split(" ");
    	if(pattern.length() != strArr.length){
    		return false;
    	}
    	Map<Character, String> map = new HashMap<Character, String>(pattern.length());
    	for(int i = 0; i < strArr.length; i++){
    		String tmp = map.get(pattern.charAt(i));
    		if(tmp != null){
    			if(!tmp.equals(strArr[i])){
    				return false;
    			}
    		}else if(map.containsValue(strArr[i])){
    			return false;
    		}else{
    			map.put(pattern.charAt(i), strArr[i]);
    		}
    	}
    	return true;
    }
	
	/**
	 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循这种模式。
		这里的 遵循 指完全匹配，例如在pattern里的每个字母和字符串 str 中的每个非空单词存在双向单映射关系。
		例如：
		pattern = "abba", str = "dog cat cat dog", 返回true 
		pattern = "abba", str = "dog cat cat fish", 返回false.
		pattern = "aaaa", str = "dog cat cat dog" , 返回false.
		pattern = "abba", str = "dog dog dog dog" , 返回false.
		说明:
		你可以假设 pattern 只包含小写字母， str 包含了由单个空格分开的小写单词。    
	 * @param pattern
	 * @param str
	 * @return
	 */
    public boolean wordPattern(String pattern, String str) {
        
    	if(pattern == null || pattern.length() == 0){
    		return false;
    	}
    	if(str == null || str.length() == 0){
    		return false;
    	}
    	String[] strArr = str.split(" ");
    	if(pattern.length() != strArr.length){
    		return false;
    	}
    	Map<Character, String> map = new HashMap<Character, String>(pattern.length());
    	Map<String, Character> cMap = new HashMap<String, Character>(pattern.length());
    	for(int i = 0; i < strArr.length; i++){
    		String tmp = map.get(pattern.charAt(i));
    		Character cTmp = cMap.get(strArr[i]);
    		if(tmp != null && !tmp.equals(strArr[i])){
    			return false;
    		}
    		if(cTmp != null && cTmp != pattern.charAt(i)){
    			return false;
    		}
    		if(tmp == null){
    			map.put(pattern.charAt(i), strArr[i]);
    		}
    		if(cTmp == null){
    			cMap.put(strArr[i], pattern.charAt(i));
    		}
    	}
    	return true;
    }

}
