package com.wangfei.leecode;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

	public static void main(String[] args) {
		CanConstruct cc = new CanConstruct();
		System.out.println(cc.canConstruct("aa", "aab"));
	}
	
	/**
	 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
		(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
		注意：
		你可以假设两个字符串均只含有小写字母。
		canConstruct("a", "b") -> false
		canConstruct("aa", "ab") -> false
		canConstruct("aa", "aab") -> true
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null){
        	return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < magazine.length(); i++){
        	Character c = magazine.charAt(i);
        	Integer count = map.get(c);
        	if(count != null){
        		++count;
        	} else {
        		count = 1;
        	}
        	map.put(c, count);
        }
        for(int i = 0; i < ransomNote.length(); i++){
        	Character c = ransomNote.charAt(i);
        	Integer count = map.get(c);
        	if(count == null || count == 0){
        		return false;
        	}
        	map.put(c, --count);
        }
    	return true;
    }

}
