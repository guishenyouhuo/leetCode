package com.wangfei.leecode;

public class FirstBadVersion {

	public static void main(String[] args) {

		
	}

	/**
	 * 你是产品经理，目前正在领导一个团队开发一个新产品。不幸的是，您的产品的最新版本没有通过质量检查。由于每个版本都是基于之前的版本开发的，所以错误版本之后的所有版本都是不好的。
		假设你有 n 个版本 [1, 2, ..., n]，你想找出第一个错误的版本，导致下面所有的错误。
		你可以通过 bool isBadVersion(version) 的接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。您应该尽量减少对 API 的调用次数。
	 * @param n
	 * @return
	 */
    public int firstBadVersion(int n) {
    	if(n <= 1){
    		return n;
    	}
    	int left = 0;
    	int right = n;
    	while(left < right){
    		int mid = (left + right) / 2;
    		if(isBadVersion(mid)){
    			right = mid;
    		} else {
    			left = mid + 1;
    		}
    	}
        return left;
    }
    
    boolean isBadVersion(int n){
    	return true;
    }
}
