package com.wangfei.thread.procons;

import java.util.LinkedList;
import java.util.Queue;

public class WaitNotifyModel {

	private final Object BUFFER_LOCK = new Object();
	private final Queue<Integer> buffer = new LinkedList<Integer>();
	private final int cap = 10;
	public static void main(String[] args) {
		WaitNotifyModel wnm = new WaitNotifyModel();
		Thread t1 = new Thread(wnm.new Producer());
		Thread t2 = new Thread(wnm.new Consumer());
		t1.start();
		t2.start();

	}
	
	class Consumer implements Runnable{

		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(500 + (long) (Math.random() * 500));
					synchronized (BUFFER_LOCK) {
						while(buffer.size() == 0){
							BUFFER_LOCK.wait();
						}
						int consumeNum = buffer.poll();
						System.out.println("消费者消费： " + consumeNum);
						BUFFER_LOCK.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	class Producer implements Runnable{

		@Override
		public void run() {
			int i = 0;
			while(true){
				try {
					Thread.sleep((long)(Math.random() * 1000));
					synchronized (BUFFER_LOCK) {
						while(cap == buffer.size()){
							BUFFER_LOCK.wait();
						}
						buffer.offer(++i);
						System.out.println("生产者生产：" + i);
						BUFFER_LOCK.notifyAll();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
