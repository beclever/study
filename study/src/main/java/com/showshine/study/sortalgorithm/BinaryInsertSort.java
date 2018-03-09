package com.showshine.study.sortalgorithm;
/**
 * 
 * 二分查找法来减少比较操作的次数，我们称为二分插入排序
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2018-03-06 09:55
 * 
 */
//分类 -------------- 内部比较排序
//数据结构 ---------- 数组
//最差时间复杂度 ---- O(n^2)
//最优时间复杂度 ---- O(nlogn)
//平均时间复杂度 ---- O(n^2)
//所需辅助空间 ------ O(1)
//稳定性 ------------ 稳定
public class BinaryInsertSort {

	public static void main(String[] args) {
		int[] arr = Utils.generateArray(5, 20);
		Utils.print(arr);
		sort(arr);
		Utils.print(arr);
		
	}
	
	public static void sort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int left = 0, right = i - 1;
			int key = arr[i];
			while(right >= left) {
				int mid = (right + left) / 2;
				if(key < arr[mid]) {
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}
			for(int j=i-1;j>=left;j--) {
				arr[j+1] =arr[j];
			}
			arr[left] = key;
		}
	}

}
