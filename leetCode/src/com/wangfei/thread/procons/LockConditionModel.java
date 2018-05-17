package com.wangfei.thread.procons;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockConditionModel {

	private final Lock BUFFER_LOCK = new ReentrantLock();
	private final Condition condition = BUFFER_LOCK.newCondition();
	private final Queue<Integer> buffer = new LinkedList<Integer>();
	private final int cap = 10;
	private final AtomicInteger increNo = new AtomicInteger(0);
	public static void main(String[] args) {
		LockConditionModel lcm = new LockConditionModel();
		Thread t1 = new Thread(lcm.new Productor());
		Thread t2 = new Thread(lcm.new Consumer());
		t1.start();
		t2.start();

	}
	
	class Productor implements Runnable{

		@Override
		public void run() {

			while(true){
				try {
					BUFFER_LOCK.lockInterruptibly();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				try{
					Thread.sleep((long)(Math.random() * 1000));
					while(buffer.size() == cap){
						condition.await();
					}
					buffer.offer(increNo.incrementAndGet());
					System.out.println("生产者提供了：" + increNo.get());
					condition.signalAll();
				}catch(Exception e){
					e.printStackTrace();
				}finally {
					BUFFER_LOCK.unlock();
				}
			}
		}
	}
	
	class Consumer implements Runnable{

		@Override
		public void run() {

			while(true){
				try {
					BUFFER_LOCK.lockInterruptibly();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				try {
					Thread.sleep(500 + (long)(Math.random() * 500));
					while(buffer.size() == 0){
						condition.await();
					}
					System.out.println("消费者使用： " + buffer.poll());
					condition.signalAll();
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					BUFFER_LOCK.unlock();
				}
			}
		}
	}
}
