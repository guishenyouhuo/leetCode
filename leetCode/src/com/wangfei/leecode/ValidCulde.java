package com.wangfei.leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class ValidCulde {

	public static void main(String[] args) {
		String s = "{[[{}]()]}";
		System.out.println(isValid(s));

	}
	
	/**
	 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
	         括号必须以正确的顺序关闭，"()" 和 "()[]{}" 是有效的但是 "(]" 和 "([)]" 不是。
	 * @param s
	 * @return
	 */
	
	public static boolean isValid(String s) {
        if(s == null || s.isEmpty()){
        	return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('(', 1);
        map.put(')', -1);
        map.put('[', 2);
        map.put(']', -2);
        map.put('{', 3);
        map.put('}', -3);
        
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
        	Integer current = map.get(s.charAt(i));
        	if(current == null){
        		return false;
        	}
        	if(stack.size() > 0){
        		Character stackTop = stack.peek();
        		if((current + map.get(stackTop)) == 0){
        			stack.pop();
        			continue;
        		}
        	}
        	stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }

}
