package com.wangfei.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wangfei.utils.ListUtils;

public class MathProblems {

	public static void main(String[] args) {

		MathProblems mp = new MathProblems();
//		System.out.println(mp.arrangeCoins(1804289383));
//		System.out.println(mp.arrangeCoins(8));
//		System.out.println(mp.arrangeCoins(Integer.MAX_VALUE));
		
//		System.out.println((4 - 1) & 2);
//		System.out.println(65535 * 65535);
		
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(mp.findDisappearedNumbers(nums));
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
    
    
    /**
     * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
		找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
		示例:
		输入: [[0,0],[1,0],[2,0]]
		输出: 2
		解释:
		两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        
    	int result = 0;
    	for (int[] pointA : points) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int[] pointB : points) {
				Integer distance = (pointA[0] - pointB[0]) * (pointA[0] - pointB[0]) + (pointA[1] - pointB[1]) * (pointA[1] - pointB[1]);
				map.put(distance, map.getOrDefault(distance, 0) + 1);
			}
			for(int item : map.values()){
				result += item * (item - 1);
			}
		}
    	
    	return result;
    }
    
    
    /**
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
		找到所有在 [1, n] 范围之间没有出现在数组中的数字。
		您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
		示例:
		输入: [4,3,2,7,8,2,3,1]
		输出: [5,6]
		
		解法：
		将出现过的数字当做下标，寻找该下标对应位置的值，并将其置为相反数，再次遍历，寻找大于零的位置，其下标值即为没有出现过的数
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
        	int index = Math.abs(nums[i]) - 1;
        	if(nums[index] > 0){
        		nums[index] = -nums[index];
        	}
        }
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] > 0){
        		result.add(i + 1);
        	}
        }
        return result;
    }

}
