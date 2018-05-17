package com.wangfei.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasikaTringle {

	public static void main(String[] args) {
		PasikaTringle pt = new PasikaTringle();
		pt.printPasika(pt.generate(8));
		System.out.println(pt.getRowB(6));

	}
	
	// 优化版本
	public List<Integer> getRowB(int rowIndex) {
        Integer[] array = new Integer[rowIndex + 1];
        if(rowIndex < 0){
        	return Arrays.asList(array);
        }
        array[0] = 1;
        for(int i = 1; i < rowIndex + 1; i++){
        	array[i] = 1;
        	for(int j = i - 1; j >= 1; j--){
        		array[j] = array[j - 1] + array[j];
        	}
        }
    	return Arrays.asList(array);
    }
	
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>(rowIndex + 1);
        if(rowIndex < 0){
        	return list;
        }
        list.add(1);
        for(int i = 1; i < rowIndex + 1; i++){
        	List<Integer> temp = new ArrayList<Integer>(rowIndex + 1);
        	temp.add(1);
        	for(int j = 1; j < i; j++){
        		temp.add(list.get(j - 1) + list.get(j));
        	}
        	temp.add(1);
        	list = temp;
        }
    	return list;
    }
	
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(numRows < 1){
    		return result;
    	}
    	List<Integer> first = new ArrayList<Integer>();
    	first.add(1);
    	result.add(first);
        for(int i = 1; i < numRows; i++){
        	List<Integer> list = new ArrayList<Integer>();
        	List<Integer> lastList = result.get(i - 1);
        	list.add(1);
        	for(int j = 1; j < i; j++){
        		list.add(lastList.get(j - 1) + lastList.get(j));
        	}
        	list.add(1);
        	result.add(list);
        }
    	return result;
    }
    
    public void printPasika(List<List<Integer>> pasika){
    	if(pasika == null || pasika.size() == 0){
    		return;
    	}
    	int rows = pasika.size();
    	for (int i = 0; i < rows; i++) {
    		int k = rows - 1 - i;
			while(k-- >= 0){
				System.out.print(" ");
			}
			List<Integer> list = pasika.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}
    }

}
