package com.showshine.study.sortalgorithm;

import java.util.Random;

/**
 * 
 *
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2018-03-05 13:07
 * 
 */
public class Utils {
	
	public static void print(int[] arr) {

		for(int i=0;i<arr.length;i++) {
			if(i == arr.length-1) {
				System.out.print(arr[i]);
			}else {
				System.out.print(arr[i]+ ",");
			}
		}
		System.out.println("");
	}
	
	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i]=arr[j];
		arr[j]=t;
	}
	
	public static int[] generateArray(int len, int max) {
		Random r = new Random();
		int[] array = new int[len];
		for(int i=0; i < len; i++) {
			array[i] = r.nextInt(max);
		}
		return array;
	}
}
