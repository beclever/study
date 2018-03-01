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

public class CountBigDataTest {

	private static int ai = 0;
	private static int n = 2000000000;
	
	public static void main(String[] args) throws InterruptedException {
		long start = System.nanoTime();
		for(int i =0; i < n; i++) {
			ai++;
		}
		System.out.println(ai);
		System.out.println("use " + (System.nanoTime() - start)/(1000 * 1000) + " ms");
	}

}
