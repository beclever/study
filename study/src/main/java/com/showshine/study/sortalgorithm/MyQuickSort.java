package com.showshine.study.sortalgorithm;
/**
 * 
 *
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2018-03-08 11:35
 * 
 */
public class MyQuickSort {

	public static void main(String[] args) {

		int[] arr = new int[] {49,38,65,97,76,13,27,49};
		arr = Utils.generateArray(10, 1000);
		sort(arr, 0 , arr.length - 1);
		Utils.print(arr);
	}
	
	public static void sort(int[] arr, int low, int hight) {
		if(low >= hight) {
			return;
		}
		int pirotIndex = partition(arr, low, hight);
		sort(arr, low, pirotIndex - 1);
		sort(arr, pirotIndex + 1, hight);
	}

	public static int partition(int[] arr, int low, int hight) {
		int pirot = arr[low];
		boolean flag = true;
		while(low < hight) {
			if(flag) {
				if(pirot > arr[hight]) {
					Utils.swap(arr, low, hight);
					flag = false;
				}else {
					--hight;
				}
			}else {
				if(pirot < arr[low]) {
					Utils.swap(arr, hight, low);
					flag = true;
				}else {
					++low;
				}
			}
		}
		return low;
	}
}
