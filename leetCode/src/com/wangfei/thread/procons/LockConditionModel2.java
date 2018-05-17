package com.wangfei.thread.procons;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockConditionModel2 {

	private final Lock CONSUME_LOCK = new ReentrantLock();
	private final Condition NOT_EMPTY = CONSUME_LOCK.newCondition();
	private final Lock PRODUCT_LOCK = new ReentrantLock();
	private final Condition NOT_FULL = PRODUCT_LOCK.newCondition();
	private final Buffer<Integer> buffer = new Buffer<Integer>();
	private final AtomicInteger bufLen = new AtomicInteger(0);
	private final int cap = 10;
	private final AtomicInteger increNo = new AtomicInteger(0);
	public static void main(String[] args) {
		LockConditionModel2 lcm = new LockConditionModel2();
		for(int i = 0; i < 5; i++){
			new Thread(lcm.new Productor()).start();
		}
		for(int i = 0; i < 3; i++){
			new Thread(lcm.new Consumer()).start();
		}
	}
	
	class Productor implements Runnable{

		@Override
		public void run() {

			while(true){
				int newBufSize = -1;
				try{
					PRODUCT_LOCK.lockInterruptibly();
					Thread.sleep((long)(Math.random() * 1000));
					while(bufLen.get() == cap){
						System.out.println("buffer is full...");
						NOT_FULL.await();
					}
					buffer.offer(increNo.incrementAndGet());
					newBufSize = bufLen.incrementAndGet();
					System.out.println("生产者提供了：" + increNo.get());
					if(newBufSize < cap){
						NOT_FULL.signalAll();
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally {
					PRODUCT_LOCK.unlock();
				}
				if(newBufSize > 0){
					try {
						CONSUME_LOCK.lockInterruptibly();
						NOT_EMPTY.signalAll();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						CONSUME_LOCK.unlock();
					}
				}
			}
		}
	}
	
	class Consumer implements Runnable{

		@Override
		public void run() {
			
			while(true){
				int newBufSize = -1;
				try {
					CONSUME_LOCK.lockInterruptibly();
					while(bufLen.get() == 0){
						System.out.println("buffer is empty...");
						NOT_EMPTY.await();
					}
					System.out.println("消费者使用： " + buffer.poll());
					newBufSize = bufLen.decrementAndGet();
					Thread.sleep(500 + (long)(Math.random() * 500));
					if(newBufSize > 0){
						NOT_EMPTY.signalAll();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					CONSUME_LOCK.unlock();
				}
				
				if(newBufSize < cap){
					try {
						PRODUCT_LOCK.lockInterruptibly();
						NOT_FULL.signalAll();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						PRODUCT_LOCK.unlock();
					}
				}
			}
		}
	}
	
	private static class Buffer<E> {
	    private Node head;
	    private Node tail;
	    Buffer() {
	      // dummy node
	      head = tail = new Node(null);
	    }
	    public void offer(E e) {
	      tail.next = new Node(e);
	      tail = tail.next;
	    }
	    public E poll() {
	      head = head.next;
	      E e = head.item;
	      head.item = null;
	      return e;
	    }
	    private class Node {
	      E item;
	      Node next;
	      Node(E item) {
	        this.item = item;
	      }
	    }
	  }
}
