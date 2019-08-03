/**
 * 选择排序
 * 原理：选择排序(Selection-sort)的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 *       然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素
 *		 均排序完毕。 
 * 时间复杂度：最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 */
public static int[] selectionSort(int[] array) {
	if (array.length == 0)
		return array;
	for (int i = 0; i < array.length; i++) {
		int minIndex = i;
		for (int j = i; j < array.length; j++) {
			if (array[j] < array[minIndex]) //找到最小的数
				minIndex = j; //将最小数的索引保存
		}
		int temp = array[minIndex];
		array[minIndex] = array[i];
		array[i] = temp;
	}
	return array;
}
