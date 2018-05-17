package com.wangfei.collection;

import java.util.ArrayList;
import java.util.List;

public class SimpleHashMap<K, V> implements SimpleMap<K, V> {

	private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	private int defaultInitialCapacity;
	private float defaultLoadFactor;
	
	private int entryUseSize;
	
	private Entry<K, V>[] table = null;
	
	public SimpleHashMap() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	public SimpleHashMap(int defaultInitSize, float defaultLoadFactor) {
		if(defaultInitSize <= 0){
			throw new IllegalArgumentException("defaultInitSize is not legal!");
		}
		if(defaultLoadFactor <= 0){
			throw new IllegalArgumentException("defaultLoadFactor is not legal!");
		}
		this.defaultInitialCapacity = defaultInitSize;
		this.defaultLoadFactor = defaultLoadFactor;
		this.entryUseSize = 0;
		table = new Entry[this.defaultInitialCapacity];
	}
	
	@Override
	public V put(K k, V v) {
		// 判断大小是否够用，不够用需要扩容并且重新hash
		if(entryUseSize >= defaultInitialCapacity * defaultLoadFactor){
			resize(2 * defaultInitialCapacity);
		}
		V oldValue = null;
		int index = hash(k) & (defaultInitialCapacity - 1);
		if(table[index] == null){
			table[index] = new Entry<K, V>(k, v, null);
			++entryUseSize;
		} else {
			Entry<K, V> entry = table[index];
			Entry<K, V> e = entry;
			while (e != null){
				if(k == e.getKey() || k.equals(e.getKey())){
					oldValue = e.getValue();
					e.value = v;
					return oldValue;
				}
				e = e.next;
			}
			table[index] = new Entry<K, V>(k, v, entry);
			++entryUseSize;
		}
		return oldValue;
	}

	private int hash(K k) {
		int hashCode = k.hashCode();
		hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
		return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
	}
	private void resize(int i) {
		this.defaultInitialCapacity = i;
		this.entryUseSize = 0;
		Entry<K, V>[] newTable = new Entry[defaultInitialCapacity];
		rehash(newTable);
	}
	private void rehash(Entry<K, V>[] newTable) {
		List<Entry<K, V>> entryList = new ArrayList<Entry<K,V>>();
		for (Entry<K, V> entry : table) {
			while(entry != null){
				entryList.add(entry);
				entry = entry.next;
			}
		}
		if(newTable.length > 0){
			table = newTable;
		}
		for (Entry<K, V> entry : entryList) {
			put(entry.getKey(), entry.getValue());
		}
	}
	@Override
	public V get(K k) {
		if(k == null){
			return null;
		}
		int index = hash(k) & (defaultInitialCapacity - 1);
		Entry<K, V> entry = table[index];
		while(entry != null){
			if(k == entry.getKey() || k.equals(entry.getKey())){
				return entry.getValue();
			}
			entry = entry.next;
		}
		return null;
	}

	class Entry<K, V> implements SimpleMap.Entry<K, V>{
		K key;
		V value;
		Entry<K, V> next;
		
		public Entry(){}
		public Entry(K key, V value, Entry<K, V> entry){
			this.key = key;
			this.value = value;
			this.next = entry;
		}

		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}
	}
}
