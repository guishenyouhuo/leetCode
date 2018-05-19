package com.wangfei.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubString {

	/**
	 * 给定一个字符串，找出不含有重复字符的 最长子串 的长度。
示例：

给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。

给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。

给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abcaf";
		System.out.println(lengthOfLongestSubstring2(s));
//		Set<Character> set = new HashSet<Character>();
//		System.out.println(set.add('a'));
//		System.out.println(set.add('a'));

	}
	// 优化版本2
	public static int lengthOfLongestSubstring2(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int longest = 0;
		for(int j = 0, i = 0; j < s.length(); j++){
			if(map.containsKey(s.charAt(j))){
				i = Math.max(i, map.get(s.charAt(j)));
			}
			longest = Math.max(longest, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
        return longest;
    }
	// 优化版本
	public static int lengthOfLongestSubstring1(String s) {
		Set<Character> set = new HashSet<Character>();
		int start = 0;
		int end = 0;
		int longest = 0;
		int length = s.length();
		while(start < length && end < length){
			if(!set.contains(s.charAt(end))){
				set.add(s.charAt(end++));
				if(longest < end - start){
					longest = end - start;
				}
			} else {
				set.remove(s.charAt(start++));
			}
		}
        return longest;
    }
	public static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<Character>();
		int index = 0;
		int longest = 0;
		while(index < s.length()){
			boolean addSucc = set.add(s.charAt(index));
			if(index == s.length() - 1 || !addSucc){
				int size = set.size();
				if(longest < size){
					longest = size;
				}
				set.clear();
				if(index != s.length() - 1){
					index = index - size;
				}
			}
			++index;
		}
        return longest;
    }

}
