package com.showshine.study.sortalgorithm;

/**
 * 
 * 冒泡排序
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2018-03-05 12:59
 * 
 */
//分类 -------------- 内部比较排序
//数据结构 ---------- 数组
//最差时间复杂度 ---- O(n^2)
//最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)
//平均时间复杂度 ---- O(n^2)
//所需辅助空间 ------ O(1)
//稳定性 ------------ 稳定
public class BubbleSort {

	public static void main(String[] args) {

		int[] a = Utils.generateArray(6, 100);
		Utils.print(a);
		sort(a);
		Utils.print(a);
		
	}
	
	public static void sort(int[] arr) {
		for(int i=0; i<arr.length - 1; i++) {
			for(int j=0; j<arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					Utils.swap(arr, j, j+1);
				}
			}
		}
	}

}
