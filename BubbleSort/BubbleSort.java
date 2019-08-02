import java.util.Arrays;

public class BubbleSort{
	public static void bubbleSort(int[] array){
		//本质上是 减治算法
		int tmp = 0;
		for(int i=0; i<array.length-1; i++){//控制比较次数
		
			boolean isSwapped = false;
			
			//经过两两比较，将最大的数冒泡到最后
			for(int j=0; j < array.length - i - 1; j++){
				if(array[j] > array[j+1]) {
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					isSwapped = true;
				}
			}	
			if(!isSwapped){ //优化
				return;
			}			
		}
	}
	
	public static void printArray(int[] array){
		for(int i=0; i<array.length; i++){
			System.out.printf("%d ",array[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		
		int[] randomArray = new int[]{ 3,5,2,12,3,56,75,32};
		
		//System.out.println(Arrays.toString(bubbleSort(randomArray)));//错误
		
		System.out.print("使用自定义方法打印数组： \t");
		printArray(randomArray);
		
		System.out.print("使用toString方法打印数组： \t");
		System.out.println(Arrays.toString(randomArray));//使用 toStirng()方法打印数组
		
		bubbleSort(randomArray);
		System.out.print("排序后的数组： \t\t\t");
		System.out.println(Arrays.toString(randomArray));
		
		//System.out.println(bubbleSort(randomArray));
		//错误: 此处不允许使用 '空' 类型
        //System.out.println(bubbleSort(new int[]{ 3,5,2,12,3,56,75,32}));
		//错误: 此处不允许使用 '空' 类型
		//System.out.println(bubbleSort(randomArray)); 中直接传入数组是无法打印的，要使用toString()方法
		
	}
}