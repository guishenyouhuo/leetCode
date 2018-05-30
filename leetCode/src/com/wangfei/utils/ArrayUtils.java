package com.wangfei.utils;

import java.util.List;

public class ArrayUtils {

	public static String listToString(List<Integer> list){
		StringBuilder sb = new StringBuilder("[");
		for(Integer i : list){
			sb.append(i).append(",");
		}
		if(sb.length() > 1){
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString();
	}
}
