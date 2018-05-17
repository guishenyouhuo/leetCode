package com.wangfei.thread.appstart;

import java.util.concurrent.CountDownLatch;

public class NetworkHealthChecker extends BaseHealthChecker {

	public NetworkHealthChecker(CountDownLatch latch) {
		super("Network Service", latch);
	}

	@Override
	public void verifyService() {
		System.out.println("Checking " + this.getServiceName());
		try {
			Thread.sleep(7000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(this.getServiceName() + "is UP");
	}

}
