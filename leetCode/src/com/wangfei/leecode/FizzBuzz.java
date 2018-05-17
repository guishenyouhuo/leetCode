package com.wangfei.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {

		FizzBuzz fb = new FizzBuzz();
		System.out.println(Arrays.toString(fb.fizzBuzz(50).toArray()));
	}
	
	/**
	 * 写一个程序，输出从 1 到 n 数字的字符串表示。1. 如果 n 是3的倍数，输出“Fizz”；2. 如果 n 是5的倍数，输出“Buzz”；3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
		示例：
		n = 15,
		返回:
		[
		    "1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"
		]
	 * @param n
	 * @return
	 */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>(n);
        for(int i = 1; i <= n; i++){
        	StringBuilder s = new StringBuilder().append(i);
        	if(i % 3 == 0 || i % 5 == 0){
        		s = new StringBuilder();
        		if(i % 3 == 0){
        			s.append("Fizz");
        		}
        		if(i % 5 == 0){
        			s.append("Buzz");
        		}
        	}
        	result.add(s.toString());
        }
    	return result;
    }

}
