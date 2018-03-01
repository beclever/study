package com.showshine.study.wait_for_multi_thread;
/**
 * 多线程统计数据，最后汇总
 *
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2018-03-01 12:02
 * 
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountBigDataByCountDownLatchTest {

	static CountDownLatch c = new CountDownLatch(2);
	private static AtomicInteger ai = new AtomicInteger(0);
	
	public static void main(String[] args) throws InterruptedException {
		long start = System.nanoTime();
		Thread countThread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i =0; i < 10*1000*10*10*10; i++) {
					ai.incrementAndGet();
				}
				c.countDown();
			}
		});
		countThread1.start();
		Thread countThread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i =0; i < 10*1000*10; i++) {
					ai.incrementAndGet();
				}
				c.countDown();
			}
		});
		countThread2.start();
		c.await();
		System.out.println(ai.get());
		System.out.println("use " + (System.nanoTime() - start)/(1000 * 1000) + " ms");
	}

}
