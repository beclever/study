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

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CountBigDataByCyclicBarrierTest {

	static CyclicBarrier cb = new CyclicBarrier(3);
	private static int ai1 = 0;
	private static int ai2 = 0;
	
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		long start = System.nanoTime();
		Thread countThread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i =0; i < 100000000; i++) {
					ai1++;
				}
				try {
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		});
		countThread1.start();
		Thread countThread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i =0; i < 100000000; i++) {
					ai2++;
				}
				try {
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		});
		countThread2.start();
		cb.await();
		System.out.println(ai1 + ai2);
		System.out.println("use " + (System.nanoTime() - start)/(1000 * 1000) + " ms");
	}

}
