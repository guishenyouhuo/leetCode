package com.wangfei.leecode;

public class GuessGameSolution {

	int guessNum = 1;
	public static void main(String[] args) {

		GuessGameSolution ggs = new GuessGameSolution();
		System.out.println(ggs.guessNumber(1));
	}
	
	/**
	 * 我们正在玩一个猜数字游戏。 游戏规则如下：
		我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
		每次你猜错了，我会告诉你这个数字是大了还是小了。
		你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
		-1 : 我的数字比较小
		 1 : 我的数字比较大
		 0 : 恭喜！你猜对了！
		示例:
		n = 10, 我选择 6.
		返回 6.
	 * @param n
	 * @return
	 */
    public int guessNumber(int n) {
    	int start = 1;
    	int end = n;
    	while(start <= end){
    		int middle = (start >> 1) + (end >> 1);
    		if(start % 2 != 0 && end % 2 != 0){
    			++middle;
    		}
	        if(guess(middle) < 0){
	        	start = middle + 1;
	        } else if(guess(middle) > 0){
	        	end = middle - 1;
	        } else {
	        	return middle;
	        }
    	}
    	return n;
    }
    
    public int guess(int num){
    	if(num < guessNum){
    		return -1;
    	} else if(num > guessNum){
    		return 1;
    	} else {
    		return 0;
    	}
    }

}
