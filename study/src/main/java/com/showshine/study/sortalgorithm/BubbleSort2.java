package com.showshine.study.sortalgorithm;

/**
 * 
 * 冒泡排序优化
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2018-03-05 12:59
 * 
 */
public class BubbleSort2 {

	public static void main(String[] args) {

		int[] a = Utils.generateArray(6, 100);
		Utils.print(a);
		sort(a);
		Utils.print(a);
		
	}
	
	public static void sort(int[] arr) {
		int i = arr.length - 1;
		while(i > 0) {
			int pos = 0;
			for(int j=0; j < i; j++) {
				if(arr[j] > arr[j+1]) {
					pos=j;
					Utils.swap(arr, j, j+1);
				}
			}
			i=pos;
		}
	}

}
