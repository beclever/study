package com.showshine.study.sortalgorithm;
/**
 * 
 *	快速排序
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2018-03-06 11:53
 * 
 */
public class QuickSort {
	
	public static void main(String[] args) {
		//int[] arr = Utils.generateArray(4, 20);
		int[] arr = {0,13,19,4};
		Utils.print(arr);
		sort(arr, 0, arr.length - 1);
		Utils.print(arr);
	}
	
	public static int partition(int arr[], int left, int right)  // 划分函数
	{
	    int pivot = arr[right];               // 这里每次都选择最后一个元素作为基准
	    int tail = left - 1;                // tail为小于基准的子数组最后一个元素的索引
	    for (int i = left; i < right; i++)  // 遍历基准以外的其他元素
	    {
	        if (arr[i] <= pivot)              // 把小于等于基准的元素放到前一个子数组末尾
	        {
	            Utils.swap(arr, ++tail, i);
	        }
	    }
	    Utils.swap(arr, tail + 1, right);           // 最后把基准放到前一个子数组的后边，剩下的子数组既是大于基准的子数组
		                           					// 该操作很有可能把后面元素的稳定性打乱，所以快速排序是不稳定的排序算法
	    
	    return tail + 1;                    // 返回基准的索引
	}

	public static void sort(int arr[], int left, int right)
	{
	    if (left >= right)
	        return;
	    int pivot_index = partition(arr, left, right); // 基准的索引
	    sort(arr, left, pivot_index - 1);
	    sort(arr, pivot_index + 1, right);
	}
}
