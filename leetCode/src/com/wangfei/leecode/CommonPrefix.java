package com.wangfei.leecode;

import java.util.HashSet;
import java.util.Set;

public class CommonPrefix {

	public static void main(String[] args) {
//		String[] strs = {"ABCFDGS","ABC",  "ABCDFEC"};
		String[] strs = {"aca","cba"};
		// String[] strs = {"C", "ABCFDGS", "ABCDFEC"};
		System.out.println(longestCommonPrefix1(strs));
	}
	
	// 优化版本
	public static String longestCommonPrefix1(String[] strs) {
		if(strs == null || strs.length == 0){
			return "";
		}
		int minLen = Integer.MAX_VALUE;
		for(String s : strs){
			if(s.length() < minLen){
				minLen = s.length();
			}
		}
		int count = 0;
        for(int i = 0; i < minLen; i++){
        	int j = 0;
        	boolean exit = false;
        	while (j < strs.length){
        		if(strs[0].charAt(i) != strs[j].charAt(i)){
        			exit = true;
        			break;
        		}
        		j++;
        	}
        	if(exit){
        		break;
        	}
        	if(j == strs.length){
        		++count;
        	}
        }
		return strs[0].substring(0, count);
    }
	
	// 最简单做法
	public static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0){
			return "";
		}
		int minLen = Integer.MAX_VALUE;
		Set<Character> set = new HashSet<Character>();
		for(String s : strs){
			if(s.length() < minLen){
				minLen = s.length();
			}
		}
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < minLen; i++){
        	int j = 0;
        	while(set.size() <= i + 1 && j < strs.length){
        		set.add(strs[j++].charAt(i));
        	}
        	if(set.size() > i + 1){
        		break;
        	}
        	if(j == strs.length){
        		result.append(strs[0].charAt(i));
        	}
        }
		return result.toString();
    }

}
