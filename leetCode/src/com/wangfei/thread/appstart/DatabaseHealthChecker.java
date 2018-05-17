package com.wangfei.thread.appstart;

import java.util.concurrent.CountDownLatch;

public class DatabaseHealthChecker extends BaseHealthChecker {

	public DatabaseHealthChecker(CountDownLatch latch) {
		super("Database Service", latch);
	}

	@Override
	public void verifyService() {
		System.out.println("Checking " + this.getServiceName());
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(this.getServiceName() + "is UP");
	}

}
