package com.wangfei.thread.procons;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;


public class BlockingQueueModel {

	private final BlockingQueue<Integer> queue = new LinkedBlockingDeque<Integer>();
	private final AtomicInteger incrNum = new AtomicInteger(0);
	public static void main(String[] args) {
		BlockingQueueModel bqm = new BlockingQueueModel();
		for(int i = 0; i < 5; i++){
			new Thread(bqm.new Producer()).start();
		}
		for(int i = 0; i < 3; i++){
			new Thread(bqm.new Consumer()).start();
		}

	}
	
	class Consumer implements Runnable{
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(500 + (long) (Math.random() * 500));
					System.out.println("consume: " + queue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	class Producer implements Runnable{
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep((long) (Math.random() * 1000));
					queue.put(incrNum.incrementAndGet());
					System.out.println("produce: " + incrNum.get());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
