package com.wangfei.collection;

public interface SimpleMap<K, V> {

	V put(K k, V v);
	V get(K k);
	
	interface Entry<K, V>{
		K getKey();
		V getValue();
	}
}
