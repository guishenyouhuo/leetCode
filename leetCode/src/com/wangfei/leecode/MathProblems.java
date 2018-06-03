package com.wangfei.leecode;

public class MathProblems {

	public static void main(String[] args) {

		MathProblems mp = new MathProblems();
		System.out.println(mp.arrangeCoins(1804289383));
		System.out.println(mp.arrangeCoins(8));
		System.out.println(mp.arrangeCoins(Integer.MAX_VALUE));
		
//		System.out.println((4 - 1) & 2);
//		System.out.println(65535 * 65535);
	}
	
	/**
	 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
		给定一个数字 n，找出可形成完整阶梯行的总行数。
		n 是一个非负整数，并且在32位有符号整型的范围内。
		示例 1:
		n = 5
		硬币可排列成以下几行:
		¤
		¤ ¤
		¤ ¤
		因为第三行不完整，所以返回2.
		示例 2:
		n = 8
		硬币可排列成以下几行:
		¤
		¤ ¤
		¤ ¤ ¤
		¤ ¤
		因为第四行不完整，所以返回3.
	 */
    public int arrangeCoins(int n) {
        if(n <= 1){
        	return n;
        }
    	int result = 0;
    	long fn = 0;
    	do{
    		++result;
    		if((result & 1) == 0){
    			long tmp = result / 2;
    			fn = (result + 1) * tmp;
    		}else{
    			long tmp = (result + 1) / 2;
    			fn = result * tmp;
    		}
    	}while(fn < n);
    	if(fn == n){
    		return result;
    	}
    	return result - 1;
    }
    
    public int arrangeCoins1(int n) {
        if(n <= 1){
        	return n;
        }
    	long result = 1;
    	long mul = result * (result + 1);
		long doubleN = 2 * (long)n;
    	while(mul < doubleN){
    		++result;
    		mul = result * (result + 1);
    	}
    	if(mul == doubleN){
    		return (int)result;
    	}
    	return (int)(result - 1);
    }

}
