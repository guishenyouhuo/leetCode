package com.wangfei.utils;

import java.util.HashMap;
import java.util.HashSet;

public class Test {

	public static void main(String[] args) {
		MyMap<String, String> myMap = new MyHashMap<String, String>();
		for(int i = 0; i < 500; i++){
			myMap.put("key" + i, "value" + i);
		}

		for(int i = 0; i < 500; i++){
			System.out.println("key" + i + ", value is : " + myMap.get("key" + i));
		}
		new HashSet<Integer>();
		new HashMap<Integer,Integer>();
	}

}
