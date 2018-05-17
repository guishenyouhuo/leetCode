package com.wangfei.leecode;

public class MaxProfit {

	public static void main(String[] args) {

		MaxProfit mp = new MaxProfit();
		int[] prices = {2,1,2,0,1};
		System.out.println(mp.maxProfit1(prices));
	}
	
	
	// 上升序列和
	public int maxProfit1(int[] prices) {
    	if(prices == null || prices.length == 0){
    		return 0;
    	}
    	int maxResult = 0;
    	for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			if(diff > 0){
				maxResult += diff;
			}
		}
    	return maxResult;
    }
	
	// 优化版本（动态规划）
	public int maxProfitB(int[] prices) {
    	if(prices == null || prices.length == 0){
    		return 0;
    	}
    	int maxResult = 0;
    	int min = prices[0];
    	for (int i = 1; i < prices.length; i++) {
			maxResult = Math.max(maxResult, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
    	return maxResult;
    }
	
    public int maxProfit(int[] prices) {
    	if(prices == null || prices.length == 0){
    		return 0;
    	}
    	int maxResult = 0;
        int minNum = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
        	if(prices[i] >= minNum){
        		continue;
        	}
        	for(int j = i + 1; j < prices.length; j++){
        		if(prices[j] < prices[i]){
        			continue;
        		}
        		if(prices[j] - prices[i] > maxResult){
        			maxResult = prices[j] - prices[i];
        		}
        	}
        	minNum = prices[i];
        }
    	return maxResult;
    }

}
