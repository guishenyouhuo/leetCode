package com.wangfei.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wangfei.utils.ArrayUtils;

/**
 * 字符串处理类题目
 * @author Administrator
 *
 */
public class StringHandle {

	public static void main(String[] args) {

		StringHandle sh = new StringHandle();
		System.out.println(ArrayUtils.listToString(sh.findAnagrams("ababa", "ab")));
	}
	
	/**
	 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
		字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
		说明：
		字母异位词指字母相同，但排列不同的字符串。
		不考虑答案输出的顺序。
		示例 1:
		输入:
		s: "cbaebabacd" p: "abc"
		输出:
		[0, 6]
		解释:
		起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
		起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
		 示例 2:
		输入:
		s: "abab" p: "ab"
		输出:
		[0, 1, 2]
		解释:
		起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
		起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
		起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
	 */
	public List<Integer> findAnagrams(String s, String p) {
    	List<Integer> result = new ArrayList<Integer>();
    	if(s.isEmpty() || p.isEmpty()){
    		return result;
    	}
    	if(s.length() < p.length()){
    		return result;
    	}
    	int[] sMap = new int[26];
    	int[] pMap = new int[26];
    	for(int i = 0; i < p.length(); i++){
    		++sMap[s.charAt(i) - 'a'];
    		++pMap[p.charAt(i) - 'a'];
    	}
    	if(arrayEqual(sMap, pMap)){
    		result.add(0);
    	}
    	for(int r = p.length() ; r < s.length(); r++){
    		++sMap[s.charAt(r) - 'a'];
    		--sMap[s.charAt(r - p.length()) - 'a'];
    		if(arrayEqual(sMap, pMap)){
        		result.add(r - p.length() + 1);
        	}
    	}
    	return result;
    }
	
	private boolean arrayEqual(int[] a, int[] b){
		if(a == null && b == null){
			return true;
		}
		if(a == null || b == null){
			return false;
		}
		if(a.length != b.length){
			return false;
		}
		for(int i = 0; i < a.length; i++){
			if(a[i] != b[i]){
				return false;
			}
		}
		return true;
	}
	/**
	 * 尝试
	 * @param s
	 * @param p
	 * @return
	 */
    public List<Integer> findAnagrams1(String s, String p) {
    	List<Integer> result = new ArrayList<Integer>();
    	if(s.isEmpty() || p.isEmpty()){
    		return result;
    	}
    	if(s.length() < p.length()){
    		return result;
    	}
    	for(int i = 0; i < s.length() - p.length() + 1; i++){
    		int sum = 0, sSum = 0, pSum = 0;
    		for(int j = 0; j < p.length(); j++){
    			sum += s.charAt(i + j) - p.charAt(j);
    			sSum += s.charAt(i + j);
    			pSum += p.charAt(j);
    		}
    		if(sum == 0 && sSum == pSum){
    			result.add(i);
    		}
    	}
    	return result;
    }

}
