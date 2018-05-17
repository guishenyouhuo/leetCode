package com.wangfei.leecode;

public class ExcelTitleConvert {

	public static void main(String[] args) {

		ExcelTitleConvert etc = new ExcelTitleConvert();
		System.out.println(etc.convertToTitle1(702));
//		for(int i = 1; i < 53; i++){
//			System.out.println(etc.convertToTitle(i));
//		}
		System.out.println(etc.titleToNumber("ZZ"));
		
	}

	/**
	 * 给定一个正整数，返回它在Excel表中相对应的列名称。
		示例：
		    1 -> A
		    2 -> B
		    3 -> C
		    ...
		    26 -> Z
		    27 -> AA
		    28 -> AB 
	 * @param n
	 * @return
	 */
    public String convertToTitle(int n) {
        char[] cArray = new char[26];
        for(int i = 0; i < cArray.length; i++){
        	cArray[i] = (char)('A' + i);
        }
        StringBuilder sb = new StringBuilder();
        while(n > cArray.length){
        	int idx = n % cArray.length;
        	if(idx == 0){
        		idx = cArray.length;
        	}
        	sb.insert(0, cArray[idx - 1]);
        	n = (n - idx) / cArray.length;
        }
        if(n > 0){
        	sb.insert(0, cArray[n - 1]);
        }
    	return sb.toString();
    }
    
    public int titleToNumber(String s) {
    	if(s.isEmpty()){
    		return 0;
    	}
    	int result = 0;
    	int index = s.length() - 1;
    	int count = 1;
    	while(index >= 0){
    		char c = s.charAt(index);
    		result += (c - 'A' + 1) * count;
    		count *= 26;
    		index--;
    	}
    	return result;
    }
    
    
    // 优化版本
    public String convertToTitle1(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 26){
        	int idx = n % 26;
        	if(idx == 0){
        		idx = 26;
        	}
        	sb.insert(0, (char)('A' + idx - 1));
        	n = (n - idx) / 26;
        }
        if(n > 0){
        	sb.insert(0, (char)('A' + n - 1));
        }
    	return sb.toString();
    }
}
