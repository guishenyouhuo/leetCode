package com.wangfei.leecode;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {

	public static void main(String[] args) {
		
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.isHappy(82));
	}
	
	/**
	 * 写一个算法来判断一个数是不是“快乐数”。
		一个数是不是快乐是这么定义的：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，或是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
		案例: 19 是一个快乐数。
		12 + 92 = 82
		82 + 22 = 68
		62 + 82 = 100
		12 + 02 + 02 = 1
	 * @param n
	 * @return
	 */
    public boolean isHappy(int n) {
    	if(n == 0){
    		return false;
    	}
    	if(n == 1){
    		return true;
    	}
        List<Integer> list = new ArrayList<Integer>();
        list.add(n);
        
        while(true){
        	int lastNum = list.get(list.size() - 1);
        	int sqrtSumNum = 0;
        	while(lastNum > 0){
        		sqrtSumNum += (lastNum % 10) * (lastNum % 10);
        		lastNum /= 10;
        	}
        	if(sqrtSumNum == 1){
        		return true;
        	}
        	if(list.contains(sqrtSumNum)){
        		return false;
        	}
        	list.add(sqrtSumNum);
        }
    }

}
