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
//		System.out.println(ArrayUtils.listToString(sh.findAnagrams("ababa", "ab")));
//		System.out.println(sh.compress1(new char[]{'a','a','a','a','a','a','a','a','a','a','a','a','b','b','b','b','b','b','b','b','b','b','b','b'}));
//		System.out.println(sh.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b','c'}));
//		System.out.println(sh.compress1(new char[]{'a'}));
		System.out.println(sh.repeatedSubstringPattern("aabaaba"));
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
    
    
    /**
     * 给定一组字符，使用原地算法将其压缩。
		压缩后的长度必须始终小于或等于原数组长度。
		数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
		在完成原地修改输入数组后，返回数组的新长度。
		进阶：
		你能否仅使用O(1) 空间解决问题？
		示例 1：
		输入： ["a","a","b","b","c","c","c"]
		输出： 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
		说明： "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
		示例 2：
		输入： ["a"]
		输出： 返回1，输入数组的前1个字符应该是：["a"]
		说明： 没有任何字符串被替代。
		示例 3：
		输入： ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
		输出： 返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
		说明： 由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。 注意每个数字在数组中都有它自己的位置。
		注意： 所有字符都有一个ASCII值在[35, 126]区间内。  1 <= len(chars) <= 1000。
     * @param chars
     * @return
     */
     public int compress(char[] chars) {
        
    	int index = 1;
    	int count = 1;
    	for(int i = 1; i < chars.length; i++){
    		if(chars[i] != chars[i - 1]){
    			if(count > 1){
    				int start = index;
	    			while(count > 0){
	    				chars[index++] = (char)(count % 10 + '0');
	    				count /= 10;
	    			}
	    			int end = index - 1;
	    			while(start < end){
	    				char temp = chars[start];
	    				chars[start] = chars[end];
	    				chars[end] = temp;
	    				++start;
	    				--end;
	    			}
    			} else {
    				count = 0;
    			}
    			chars[index++] = chars[i];
    		}
    		++count;
    	}
    	if(count > 1){
			int start = index;
			while(count > 0){
				chars[index++] = (char)(count % 10 + '0');
				count /= 10;
			}
			int end = index - 1;
			while(start < end){
				char temp = chars[start];
				chars[start] = chars[end];
				chars[end] = temp;
				++start;
				--end;
			}
		}
    	return index;
    }
     
     /**
      * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
		示例 1: 输入: "abab"
		输出: True
		解释: 可由子字符串 "ab" 重复两次构成。
		示例 2: 输入: "aba"
		输出: False
		示例 3: 输入: "abcabcabcabc"
		输出: True
		解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
      * @param s
      * @return
      */
     public boolean repeatedSubstringPattern(String s) {
         
    	 char[] charArray = s.toCharArray();
    	 int len = charArray.length;
    	 for(int i = 2; i <= len; i++){
    		 if(len % i != 0){
    			 continue;
    		 }
    		 int subLen = len / i;
    		 int j = subLen;
    		 for(; j < len; j++){
    			 if(charArray[j] != charArray[j - subLen]){
    				 break;
    			 }
    		 }
    		 if(j == len){
    			 return true;
    		 }
    	 }
    	 return false;
     }
}
