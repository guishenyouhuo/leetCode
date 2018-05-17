package com.wangfei.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShareData {

	private static int count = 0;
	private Lock lock = new ReentrantLock();
	public static void main(String[] args) {
		final ShareData shareData = new ShareData();
		for(int i = 0; i < 10; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i = 0; i < 100; i++){
						try {
							shareData.addCount();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.print(count + " ");
				}
			}).start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("count = " + count);
	}
	
	public void addCount() throws InterruptedException{
		lock.lockInterruptibly();
		try{
			++count;
		}finally{
			lock.unlock();
		}
	}

}
