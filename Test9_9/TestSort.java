import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        int[] arr = {5,2,8,3,7,0,15,24,6,89,73,26,54,23,20,4,76,23,24,89};
        //HeapSort.sort(arr);
        //QuickSort.quickSort(arr);
        //QuickSort.sort(arr);
        MergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}