package com.wangfei.leecode;


public class Isomorphic {

	public static void main(String[] args) {

		Isomorphic iph = new Isomorphic();
		System.out.println(iph.isIsomorphic("paper", "title"));
		String s = "caab";
		System.out.println(s.indexOf('a'));
	}
	/**
	 * 给定两个字符串 s 和 t，判断它们是否是同构的。
		如果 s 中的字符可以被替换最终变成 t ，则两个字符串是同构的。
		所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
		例如，
		给定 "egg", "add", 返回 true.
		给定 "foo", "bar", 返回 false.
		给定 "paper", "title", 返回 true.
		注意：
		你可以假设 s 和 t 具有相同的长度。
	 * @param s
	 * @param t
	 * @return
	 */
    public boolean isIsomorphic(String s, String t) {
    	if(s == null || t == null){
    		return false;
    	}
    	if(s.length() != t.length()){
    		return false;
    	}
    	for(int i = 0; i < s.length(); i++){
    		char sChar = s.charAt(i);
    		char tChar = t.charAt(i);
    		int firstIndexOfSChar = s.indexOf(sChar);
    		int firstIndexOfTChar = t.indexOf(tChar);
    		// 至少有一个不是第一次出现
    		if(firstIndexOfTChar != i || firstIndexOfSChar != i){
    			if(firstIndexOfSChar != firstIndexOfTChar){
    				return false;
    			}
    		}
    	}
        return true;
    }
}
