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
		
//		int[] nums = {4,3,2,7,8,2,3,1};
//		System.out.println(mp.findDisappearedNumbers(nums));
		/**
		 * [10,9,8,7]
			[5,6,7,8]
		 */
//		int g[] = {10,9,8,7};
//		int s[] = {5,6,7,8};
//		System.out.println(mp.findContentChildren(g, s));
//		System.out.println("over");
//		System.out.println(mp.poorPigs(1000, 15, 60));
//		System.out.println(Integer.toBinaryString(255));
//		System.out.println(Integer.toBinaryString(255));
//		System.out.println(mp.hammingDistance(255, 255));
		int[][] grid = {{0,1,0,0},
		       		 {1,1,1,0},
		    		 {0,1,0,0},
		    		 {1,1,0,0}};
//		System.out.println(mp.islandPerimeter(grid));
		//[1,1,1,1,1,1,999,999,999,999,999]
		//[499,500,501]
		/*
		 [282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923]
[823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612]
		 */
//		 int[] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
//		 int[] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
//		System.out.println(mp.findRadius(houses, heaters));
//		System.out.println(Integer.toBinaryString(12345));
//		System.out.println(Integer.toBinaryString(4038));
		System.out.println(Integer.toBinaryString(2147483647));
		System.out.println(mp.findComplement(2147483647));
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

    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
		注意：
		你可以假设胃口值为正。
		一个小朋友最多只能拥有一块饼干。
		示例 1:
		输入: [1,2,3], [1,1]
		输出: 1
		解释: 
		你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
		虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
		所以你应该输出1。
		示例 2:
		输入: [1,2], [1,2,3]
		输出: 2
		解释: 
		你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
		你拥有的饼干数量和尺寸都足以让所有孩子满足。
		所以你应该输出2.
     * 使用堆排序思想，分别对两个数组建立小顶堆过程中比较大小
     */
    public int findContentChildren(int[] g, int[] s) {
        if(g == null || g.length == 0){
        	return 0;
        }
        if(s == null || s.length == 0){
        	return 0;
        }
        int result = 0;
        boolean gChange = true;
        for(int i = g.length - 1, j = s.length - 1; i >= 0 && j >= 0; i--, j--){
        	if(gChange){
        		adjustHeap(g, i);
        	}
        	adjustHeap(s, j);
        	if(s[0] >= g[0]){
        		++result;
        		gChange = true;
        	} else {
        		++i;
        		gChange = false;
        	}
        	int temp = s[0];
        	s[0] = s[j];
        	s[j] = temp;
        	if(gChange){
	        	temp = g[0];
	        	g[0] = g[i];
	        	g[i] = temp;
        	}
        }
    	return result;
    }
    
    // 调整小顶堆
    private void adjustHeap(int[] array, int lastIndex){
    	int halfIndex = (lastIndex - 1) >> 1;
    	for(int i = halfIndex; i >= 0; i--){
    		int tmp = array[i];
    		int minIndex = 2 * i + 1;
    		if(minIndex + 1 <= lastIndex && array[minIndex + 1] < array[minIndex]){
    			++minIndex;
    		}
    		if(array[minIndex] < array[i]){
    			array[i] = array[minIndex];
    			array[minIndex] = tmp;
    		}
    	}
    }
    
    
    /**
     * 有1000只水桶，其中有且只有一桶装的含有毒药，其余装的都是水。它们从外观看起来都一样。如果小猪喝了毒药，它会在15分钟内死去。
		问题来了，如果需要你在一小时内，弄清楚哪只水桶含有毒药，你最少需要多少只猪？
		回答这个问题，并为下列的进阶问题编写一个通用算法。
		进阶:
		假设有 n 只水桶，猪饮水中毒后会在 m 分钟内死亡，你需要多少猪（x）就能在 p 分钟内找出“有毒”水桶？n只水桶里有且仅有一只有毒的桶。
     * @param buckets
     * @param minutesToDie
     * @param minutesToTest
     * @return
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int tryTimes = minutesToTest / minutesToDie + 1;
        int num = 0;
        while (Math.pow(tryTimes, num) < buckets){
        	++num;
        }
    	return num;
    }
    
    /**
     * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
		示例:
		输入: [1,2,3]
		输出: 3
		解释:
		只需要3次移动（注意每次移动会增加两个元素的值）：
		[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
		
		解法：此题需要找到规律   最小移动次数即为数组中每个元素减去最小数的和
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
     
    	int min = Integer.MAX_VALUE;
    	for (int num : nums) {
			min = Math.min(num, min);
		}
    	int cnt = 0;
    	for (int num : nums) {
			if(num > min){
				cnt += num - min;
			}
		}
    	return cnt;
    }
    
    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
		给出两个整数 x 和 y，计算它们之间的汉明距离。
		注意：
		0 ≤ x, y < 231.
		示例:
		输入: x = 1, y = 4
		输出: 2
		解释:
		1   (0 0 0 1)
		4   (0 1 0 0)
		       ↑   ↑
		上面的箭头指出了对应二进制位不同的位置。
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int and = x & y;
        int or = x | y;
        int xor = and ^ or;
        int result = 0;
        while (xor > 0){
        	++result;
        	xor &= (xor - 1);
        }
    	return result;
    }
    
    /**
     * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
		示例 :
		[[0,1,0,0],
		 [1,1,1,0],
		 [0,1,0,0],
		 [1,1,0,0]]
		答案: 16
		解释: 它的周长是下面图片中的 16 个黄色的边：
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
    	int result = 0;
    	for(int i = 0; i < grid.length; i++){
    		for(int j = 0; j < grid[i].length; j++){
    			if(grid[i][j] == 1){
    				if(j == 0){
    					++result;
    				}
    				if(j == grid[i].length - 1){
    					++result;
    				}
    				if(j > 0 && grid[i][j - 1] == 0){
    					++result;
    				}
    				if(j < grid[i].length - 1 && grid[i][j + 1] == 0){
    					++result;
    				}
    				if(i == 0){
    					++result;
    				}
    				if(i == grid.length - 1){
    					++result;
    				}
    				if(i > 0 && grid[i - 1][j] == 0){
    					++result;
    				}
    				if(i < grid.length - 1 && grid[i + 1][j] == 0){
    					++result;
    				}
    			}
    		}
    	}
    	return result;
    }
    
    
    /**
     * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
		现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
		所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
		说明:
		给出的房屋和供暖器的数目是非负数且不会超过 25000。
		给出的房屋和供暖器的位置均是非负数且不会超过10^9。
		只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
		所有供暖器都遵循你的半径标准，加热的半径也一样。
		示例 1:
		输入: [1,2,3],[2]
		输出: 1
		解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
		示例 2:
		输入: [1,2,3,4],[1,4]
		输出: 1
		解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
    	Arrays.sort(houses);
    	Arrays.sort(heaters);
    	int result = Integer.MIN_VALUE;
        for(int i = 0; i < houses.length; i++){
        	if(i > 0 && houses[i] == houses[i - 1]){
        		continue;
        	}
        	int closedHeaterIdx = 0;
        	int radius = Integer.MAX_VALUE;
        	while(closedHeaterIdx < heaters.length){
        		radius = Math.min(radius, Math.abs(houses[i] - heaters[closedHeaterIdx]));
        		if(heaters[closedHeaterIdx] > houses[i]){
        			break;
        		}
        		++closedHeaterIdx;
        	}
        	result = Math.max(result, radius);
        }
    	return result;
    }
    
    
    /**
     * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
		注意:
		给定的整数保证在32位带符号整数的范围内。
		你可以假定二进制数不包含前导零位。
		示例 1:
		输入: 5
		输出: 2
		解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
		示例 2:
		输入: 1
		输出: 0
		解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
     * @param num
     * @return
     */
    public int findComplement(int num) {
        long mask = 1;
        while (mask < num){
        	mask <<= 1;
        }
    	return (int) ((~num) & (mask - 1));
    }
}
