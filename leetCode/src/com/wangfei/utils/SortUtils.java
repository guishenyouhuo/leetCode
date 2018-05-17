package com.wangfei.utils;

import java.util.Arrays;
import java.util.Random;

public final class SortUtils {

	/*****************************
	 * 排序算法
	 *****************************/
	// 冒泡排序
	public static void bubbleSort(int[] nums){
		for(int i = 0; i < nums.length; i++){
			for(int j = i + 1; j < nums.length; j++){
				if(nums[i] > nums[j]){
					// 交换
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}
	
	// 插入排序
	public static void insertSort(int[] nums){
		for(int i = 1; i < nums.length; i++){
			int a = nums[i];
			int j = i - 1;
			while(j >= 0 && nums[j] > a){
				nums[j + 1] = nums[j];
				j--;
			}
			nums[j + 1] = a;
		}
	}
	
	// 选择排序
	public static void selectSort(int[] nums){
		for(int i = 0; i < nums.length; i++){
			int min = nums[i];
			int minIndex = i;
			for(int j = i + 1; j < nums.length; j++){
				if(nums[j] < min){
					min = nums[j];
					minIndex = j;
				}
			}
			if(minIndex != i){
				int temp = nums[minIndex];
				nums[minIndex] = nums[i];
				nums[i] = temp;
			}
		}
	}
	
	// 快速排序
	public static void quickSort(int[] nums){
		sortCycle(nums, 0, nums.length - 1);
	}
	public static void sortCycle(int[] nums, int low, int high){
		int middle = quickSortHandle(nums, low, high);
		if(middle == -1){
			return;
		}
		sortCycle(nums, low, middle - 1);
		sortCycle(nums, middle + 1, high);
	}
	public static int quickSortHandle(int[] nums, int low, int high){
		if(low > high || low >= nums.length || high >= nums.length){
			return -1;
		}
		int tempNum = nums[high];
		while(low < high){
			while(low < high && nums[low] <= tempNum){
				low++;
			}
			nums[high] = nums[low];
			while(low < high && tempNum <= nums[high]){
				high--;
			}
			nums[low] = nums[high];
		}
		nums[low] = tempNum;
		return low;
	}
	
	// 堆排序
	public static void heapSort(int[] nums){
		if(nums == null || nums.length < 2){
			return;
		}
		int lastIndex = nums.length - 1;
		do{
			buildHeap(lastIndex, nums);
			// 堆顶与末尾交换
			int top = nums[0];
			nums[0] = nums[lastIndex];
			nums[lastIndex--] = top;
		} while(lastIndex > 0);
	}
	
	public static void buildHeap(int lastIndex, int[] nums){
		int halfIndex = (lastIndex - 1) >> 1;
		// 建大顶堆
		for(int i = halfIndex; i >= 0; i--){
			int tmp = nums[i];
			int left = nums[2 * i + 1];
			int maxIndex = 2 * i + 1;
			if(maxIndex + 1 <= lastIndex && nums[maxIndex + 1] > left){
				maxIndex = maxIndex + 1;
			}
			if(nums[maxIndex] > nums[i]){
				nums[i] = nums[maxIndex];
				nums[maxIndex] = tmp;
			}
		}
	}
//	public static void main(String[] args) {
////		int[] nums = {-9,-7,-3, 2,5,-4,-1,7,3,6,11,34,21,17,-8,-33};
//		int[] nums = new int[100];
//		for(int i = 0; i < nums.length; i++){
//			nums[i] = new Random().nextInt(1000) - 200;
//		}
//		System.out.println(Arrays.toString(nums));
//		heapSort(nums);
//		System.out.println(Arrays.toString(nums));
//	}
}
