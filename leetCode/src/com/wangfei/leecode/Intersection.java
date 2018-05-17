package com.wangfei.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wangfei.utils.SortUtils;

public class Intersection {

	public static void main(String[] args) {

		Intersection is = new Intersection();
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		int[] result = is.intersectBySort(nums1, nums2);
		for(int i : result){
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 给定两个数组，写一个函数来计算它们的交集。
		例子:
		 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
		提示:
		每个在结果中的元素必定是唯一的。
		我们可以不考虑输出结果的顺序。
	 */
    public int[] intersection(int[] nums1, int[] nums2) {
    	if(nums1 == null || nums2 == null){
    		return null;
    	}
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++){
        	map.put(nums1[i], 0);
        }
        int count = 0;
        for(int i = 0; i < nums2.length; i++){
        	Integer mapNum = map.get(nums2[i]);
        	if(mapNum != null){
        		if(mapNum == 0){
        			++count;
        		}
        		map.put(nums2[i], ++mapNum); 
        	}
        }
        int[] result = new int[count];
        Set<Integer> keySet = map.keySet();
        int i = 0;
        for(Integer key : keySet){
        	if(map.get(key) > 0 && i < count){
        		result[i++] = key;
        	}
        }
    	return result;
    }
    
    /**
     * 给定两个数组，写一个方法来计算它们的交集。
		例如:
		给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
		注意：
		   输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
		   我们可以不考虑输出结果的顺序。
		跟进:
		如果给定的数组已经排好序呢？你将如何优化你的算法？
		如果 nums1 的大小比 nums2 小很多，哪种方法更优？
		如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
     */
    public int[] intersect(int[] nums1, int[] nums2) {
    	if(nums1 == null || nums2 == null){
    		return null;
    	}
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++){
        	Integer intInMap = map.get(nums1[i]);
        	if(intInMap != null){
        		map.put(nums1[i], ++intInMap);
        	} else {
        		map.put(nums1[i], 1);
        	}
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int num : nums2){
        	Integer numCount = map.get(num);
        	if(numCount != null && numCount > 0){
        		result.add(num);
        		map.put(num, --numCount);
        	}
        }
        int[] arrResult = new int[result.size()];
        for(int i = 0; i< result.size(); i++){
        	arrResult[i] = result.get(i);
        }
    	return arrResult;
    }
    
    public int[] intersectBySort(int[] nums1, int[] nums2) {
    	if(nums1 == null || nums2 == null){
    		return null;
    	}
        SortUtils.heapSort(nums1);
        SortUtils.heapSort(nums2);
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<Integer>();
        while(i < nums1.length && j < nums2.length){
        	if(nums1[i] < nums2[j]){
        		++i;
        	} else if (nums1[i] > nums2[j]){
        		++j;
        	} else {
        		result.add(nums1[i]);
        		++i;
        		++j;
        	}
        }
        int[] arrResult = new int[result.size()];
        for(int k = 0; k< result.size(); k++){
        	arrResult[k] = result.get(k);
        }
    	return arrResult;
    }

}
