package com.wangfei.thread.procons;

import java.util.ArrayList;
import java.util.List;

public class ProductConsumer {

	private static final int MAX_COUNT = 20;
	private static List<Integer> resources = new ArrayList<Integer>(MAX_COUNT);
	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Producer(resources, MAX_COUNT));
		t1.start();
//		Thread.sleep(1);
		Thread t2 = new Thread(new Consumer(resources, MAX_COUNT));
		t2.start();
	}
	
	

}

//生产者
class Producer implements Runnable{

	List<Integer> resources;
	int maxCount;
	public Producer(List<Integer> resources, int maxCount) {
		this.resources = resources;
		this.maxCount = maxCount;
	}
	@Override
	public void run() {
		for(int i = 0; i < 20; i++){
			if(resources.size() < maxCount){
				System.out.println("生产者添加: " + (i + 1));
				resources.add(i + 1);
			} else {
				System.out.println("队列已满！");
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
	
// 消费者
class Consumer implements Runnable{

	List<Integer> resources;
	int maxCount;
	public Consumer(List<Integer> resources, int maxCount) {
		this.resources = resources;
		this.maxCount = maxCount;
	}
	@Override
	public void run() {
		for(int i = 0; i < 20; i++){
			if(resources.size() > 0){
				System.out.println("消费者取出： " + resources.remove(0));
			} else {
				System.out.println("队列已空！");
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

