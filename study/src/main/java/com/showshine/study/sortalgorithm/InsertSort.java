package com.showshine.study.sortalgorithm;
/**
 * 
 *
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2018-03-05 23:13
 * 
 */
//分类 ------------- 内部比较排序
//数据结构 ---------- 数组
//最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
//最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
//平均时间复杂度 ---- O(n^2)
//所需辅助空间 ------ O(1)
//稳定性 ------------ 稳定
public class InsertSort {

	public static void main(String[] args) {

		int[] arr = Utils.generateArray(5, 10);
		Utils.print(arr);
		sort(arr);
		Utils.print(arr);
	}
	
	public static void sort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int j = i - 1;
			int temp = arr[i];
			while(j >= 0 && arr[j]> temp) {
				arr[j+1] = arr[j];
				j--;
			}
			if(j != i - 1) {
				arr[j+1] = temp;
			}
		}
	}
}
