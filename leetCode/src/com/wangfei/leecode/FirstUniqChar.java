package com.wangfei.leecode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

	public static void main(String[] args) {

		FirstUniqChar fuc = new FirstUniqChar();
		System.out.println(fuc.firstUniqChar("leetcode"));
	}
	
	/**
	 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
		案例:
		s = "leetcode"
		返回 0.
		s = "loveleetcode",
		返回 2.
		注意事项：您可以假定该字符串只包含小写字母。
	 * @param s
	 * @return
	 */
	public int firstUniqChar(String s) {
        if(s == null){
        	return -1;
        }
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
        	++map[s.charAt(i) - 'a'];
        }
        for(int i = 0; i < s.length(); i++){
        	if(map[s.charAt(i) - 'a'] == 1){
        		return i;
        	}
        }
    	return -1;
    }
    public int firstUniqChar1(String s) {
        if(s == null){
        	return -1;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
        	Character c = s.charAt(i);
        	Integer count = map.get(c);
        	if(count != null){
        		++count;
        	} else {
        		count = 1;
        	}
        	map.put(c, count);
        }
        for(int i = 0; i < s.length(); i++){
        	if(map.get(s.charAt(i)) == 1){
        		return i;
        	}
        }
    	return -1;
    }

}
