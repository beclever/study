package com.showshine.study.sortalgorithm;
/**
 * 
 *	堆排序
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2018-03-06 13:22
 * 
 */

//分类 -------------- 内部比较排序
//数据结构 ---------- 数组
//最差时间复杂度 ---- O(nlogn)
//最优时间复杂度 ---- O(nlogn)
//平均时间复杂度 ---- O(nlogn)
//所需辅助空间 ------ O(1)
//稳定性 ------------ 不稳定
public class HeapSort {

	public static void main(String[] args) {
		int[] arr = Utils.generateArray(4, 20);
		Utils.print(arr);
		sort(arr, arr.length);
		Utils.print(arr);

	}
	public static void heapify(int arr[], int i, int size)  // 从A[i]向下进行堆调整
	{
	    int left_child = 2 * i + 1;         // 左孩子索引
	    int right_child = 2 * i + 2;        // 右孩子索引
	    int max = i;                        // 选出当前结点与其左右孩子三者之中的最大值
	    if (left_child < size && arr[left_child] > arr[max])
	        max = left_child;
	    if (right_child < size && arr[right_child] > arr[max])
	        max = right_child;
	    if (max != i)
	    {
	        Utils.swap(arr, i, max);                // 把当前结点和它的最大(直接)子节点进行交换
	        heapify(arr, max, size);          // 递归调用，继续从当前结点向下进行堆调整
	    }
	}

	public static int buildHeap(int A[], int n)           // 建堆，时间复杂度O(n)
	{
	    int heap_size = n;
	    for (int i = heap_size / 2 - 1; i >= 0; i--) // 从每一个非叶结点开始向下进行堆调整
	        heapify(A, i, heap_size);
	    return heap_size;
	}

	public static void sort(int A[], int n)
	{
	    int heap_size = buildHeap(A, n);    // 建立一个最大堆
	    while (heap_size > 1) // 堆（无序区）元素个数大于1，未完成排序
	    {
	        // 将堆顶元素与堆的最后一个元素互换，并从堆中去掉最后一个元素
	        // 此处交换操作很有可能把后面元素的稳定性打乱，所以堆排序是不稳定的排序算法
	    	Utils.swap(A, 0, --heap_size);
	        heapify(A, 0, heap_size);     // 从新的堆顶元素开始向下进行堆调整，时间复杂度O(logn)
	    }
	}

}
