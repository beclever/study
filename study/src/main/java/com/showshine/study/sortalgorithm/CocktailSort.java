package com.showshine.study.sortalgorithm;

/**
 * 
 * 鸡尾酒排序
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2018-03-05 12:59
 * 
 */
//分类 -------------- 内部比较排序
//数据结构 ---------- 数组
//最差时间复杂度 ---- O(n^2)
//最优时间复杂度 ---- 如果序列在一开始已经大部分排序过的话,会接近O(n)
//平均时间复杂度 ---- O(n^2)
//所需辅助空间 ------ O(1)
//稳定性 ------------ 稳定
public class CocktailSort {

	public static void main(String[] args) {

		//int[] a = Utils.generateArray(6, 100);
		int[] b = {2,3,4,5,1};
		Utils.print(b);
		sort(b);
		Utils.print(b);
		
	}
	
	public static void sort(int[] arr) {
		int left = 0;                            // 初始化边界
	    int right = arr.length - 1;
	    while (left < right)
	    {
	        for (int i = left; i < right; i++)   // 前半轮,将最大元素放到后面
	        {
	            if (arr[i] > arr[i + 1])
	            {
	                Utils.swap(arr, i, i + 1);
	            }
	        }
	        right--;
	        for (int i = right; i > left; i--)   // 后半轮,将最小元素放到前面
	        {
	            if (arr[i - 1] > arr[i])
	            {
	            	Utils.swap(arr, i - 1, i);
	            }
	        }
	        left++;
	    }
	}

}
