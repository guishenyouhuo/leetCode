package com.wangfei.leecode;

public class Anagram {

	public static void main(String[] args) {

		Anagram ag = new Anagram();
		System.out.println(ag.isAnagram("rat", "car"));
	}
	
	/**
	 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
		例如，
		s = "anagram"，t = "nagaram"，返回 true
		s = "rat"，t = "car"，返回 false
		注意:
		假定字符串只包含小写字母。
		提升难度:
		输入的字符串包含 unicode 字符怎么办？你能能否调整你的解法来适应这种情况？
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
		int [] alphabat = new int[26];
		if(s == null || t == null){
			return false;
		}
		if(s.length() != t.length()){
			return false;
		}
		for(int i = 0; i < s.length(); i++){
			++alphabat[s.charAt(i) - 'a'];
			--alphabat[t.charAt(i) - 'a'];
		}
		for(int i : alphabat){
			if(i != 0){
				return false;
			}
		}
		return true;
	}

}
