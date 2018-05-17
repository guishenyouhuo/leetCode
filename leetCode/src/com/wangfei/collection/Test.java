package com.wangfei.collection;


public class Test {

	public static void main(String[] args) {
		SimpleMap<String, String> myMap = new SimpleHashMap<String, String>();
		for(int i = 0; i < 500; i++){
			myMap.put("key" + i, "value" + i);
		}

		for(int i = 0; i < 500; i++){
			System.out.println("key" + i + ", value is : " + myMap.get("key" + i));
		}
	}

}
