package com.showshine.study.sortalgorithm;
/**
 * 
 *
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2018-03-06 13:26
 * 
 */

//分类 -------------- 内部比较排序
//数据结构 ---------- 数组
//最差时间复杂度 ---- O(nlogn)
//最优时间复杂度 ---- O(nlogn)
//平均时间复杂度 ---- O(nlogn)
//所需辅助空间 ------ O(n)
//稳定性 ------------ 稳定
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = Utils.generateArray(4, 20);
		Utils.print(arr);
		MergeSortRecursion(arr, 0, arr.length - 1);          // 递归实现
		Utils.print(arr);
		arr = Utils.generateArray(4, 20);
		Utils.print(arr);
	    MergeSortIteration(arr, arr.length);                 // 非递归实现
		Utils.print(arr);

	}
	public static void Merge(int arr[], int left, int mid, int right)// 合并两个已排好序的数组A[left...mid]和A[mid+1...right]
	{
	    int len = right - left + 1;
	    int[] temp = new int[len];       // 辅助空间O(n)
	    int index = 0;
	    int i = left;                   // 前一数组的起始元素
	    int j = mid + 1;                // 后一数组的起始元素
	    while (i <= mid && j <= right)
	    {
	        temp[index++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];  // 带等号保证归并排序的稳定性
	    }
	    while (i <= mid)
	    {
	        temp[index++] = arr[i++];
	    }
	    while (j <= right)
	    {
	        temp[index++] = arr[j++];
	    }
	    for (int k = 0; k < len; k++)
	    {
	        arr[left++] = temp[k];
	    }
	}

	public static void MergeSortRecursion(int arr[], int left, int right)    // 递归实现的归并排序(自顶向下)
	{
	    if (left == right)    // 当待排序的序列长度为1时，递归开始回溯，进行merge操作
	        return;
	    int mid = (left + right) / 2;
	    MergeSortRecursion(arr, left, mid);
	    MergeSortRecursion(arr, mid + 1, right);
	    Merge(arr, left, mid, right);
	}

	public static void MergeSortIteration(int arr[], int len)    // 非递归(迭代)实现的归并排序(自底向上)
	{
	    int left, mid, right;// 子数组索引,前一个为A[left...mid]，后一个子数组为A[mid+1...right]
	    for (int i = 1; i < len; i *= 2)        // 子数组的大小i初始为1，每轮翻倍
	    {
	        left = 0;
	        while (left + i < len)              // 后一个子数组存在(需要归并)
	        {
	            mid = left + i - 1;
	            right = mid + i < len ? mid + i : len - 1;// 后一个子数组大小可能不够
	            Merge(arr, left, mid, right);
	            left = right + 1;               // 前一个子数组索引向后移动
	        }
	    }
	}

}
