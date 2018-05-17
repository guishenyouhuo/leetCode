package com.wangfei.leecode;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {

	public static void main(String[] args) {

		FindTheDifference ftd = new FindTheDifference();
		System.out.println(ftd.findTheDifference("abcd", "abced"));
	}
	
	/**
	 * 给定两个字符串 s 和 t，它们只包含小写字母。
		字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
		请找出在 t 中被添加的字母。
		示例:
		输入：
		s = "abcd"
		t = "abcde"
		输出：
		e
		解释：
		'e' 是那个被添加的字母。
	 * @param s
	 * @param t
	 * @return
	 */
    public char findTheDifference(String s, String t) {
        
    	if(s == null || t == null){
        	return 0;
        }
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
        	++map[s.charAt(i) - 'a'];
        }
        for(int i = 0; i < t.length(); i++){
        	if(map[t.charAt(i) - 'a'] == 0){
        		return t.charAt(i);
        	}
        	--map[t.charAt(i) - 'a'];
        }
    	return 0;
    }

}
