package com.showshine.study.sortalgorithm;
/**
 * 
 * 选择排序
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2018-03-05 16:00
 * 
 */
//数据结构 ---------- 数组
//最差时间复杂度 ---- O(n^2)
//最优时间复杂度 ---- O(n^2)
//平均时间复杂度 ---- O(n^2)
//所需辅助空间 ------ O(1)
//稳定性 ------------ 不稳定
public class SelectionSort {

	public static void main(String[] args) {

		int[] arr = Utils.generateArray(10, 10);
		Utils.print(arr);
		sort(arr);
		Utils.print(arr);
	}
	
	public static void sort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for(int j=i; j<arr.length-1; j++) {
				if(arr[min] > arr[j+1]) {
					min = j+1;
				}
			}
			if(min > i) {
				Utils.swap(arr, min, i);
			}
		}
		
	}

}
