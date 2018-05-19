package com.wangfei.leecode;

public class RomanNum {

	public static void main(String[] args) {
		String s = "DCXLI";
		System.out.println(romeToInt(s));
		System.out.println(a2r(2));
	}
	
	public static int romeToInt(String s){
		int[] graph = new int[400];
		graph['I'] = 1;
		graph['V'] = 5;
		graph['X'] = 10;
		graph['L'] = 50;
		graph['C'] = 100;
		graph['D'] = 500;
		graph['M'] = 1000;
		char[] toArray = s.toCharArray();
		int sum = graph[toArray[0]];
		for (int i = 0; i < toArray.length - 1; i++) {
			if(graph[toArray[i]] >= graph[toArray[i + 1]]){
				sum += graph[toArray[i + 1]];
			} else {
				sum += graph[toArray[i + 1]] - 2 * graph[toArray[i]];
			}
		}
		return sum;
	}
	
	
	
	
	
	
	private static String a2r(int num){  
        if(num > 3999 || num < 0){
        	return "-1";
        } 
        int[] aArray = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rArray = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String rNumber = "";
        for(int i = 0; i < aArray.length; i++){
        	while(num >= aArray[i]){
        		rNumber += rArray[i];
        		num -= aArray[i];
        	}
        }
        return rNumber;  
    }  

}
