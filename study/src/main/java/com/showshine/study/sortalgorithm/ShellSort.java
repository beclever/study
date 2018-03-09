package com.showshine.study.sortalgorithm;
/**
 * 
 *	希尔排序
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2018-03-06 10:37
 * 
 */
//分类 -------------- 内部比较排序
//数据结构 ---------- 数组
//最差时间复杂度 ---- 根据步长序列的不同而不同。已知最好的为O(n(logn)^2)
//最优时间复杂度 ---- O(n)
//平均时间复杂度 ---- 根据步长序列的不同而不同。
//所需辅助空间 ------ O(1)
//稳定性 ------------ 不稳定
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = Utils.generateArray(4, 20);
		Utils.print(arr);
		sort(arr);
		Utils.print(arr);
	}

	public static void sort(int arr[])
	{
	    int h = 0;
	    while (h <= arr.length)// 生成初始增量
	    {
	        h = 3 * h + 1;
	    }
	    while (h >= 1)
	    {
	        for (int i = h; i < arr.length; i++)
	        {
	            int j = i - h;
	            int get = arr[i];
	            while (j >= 0 && arr[j] > get)
	            {
	                arr[j + h] = arr[j];
	                j = j - h;
	            }
	            arr[j + h] = get;
	        }
	        h = (h - 1) / 3;// 递减增量
	    }
	}
}
