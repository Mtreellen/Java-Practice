/*
堆排
 */
public class HeapSort {
    private static void adjust(int[] arr, int root, int end){
        int c = 2*root+1;//左孩子
        int temp = 0;
        while(c < end){
            c = c+1<end ? (arr[c] < arr[c+1] ? c+1 : c) : c;//最大的孩子
            if(arr[c] > arr[root]){
                temp = arr[c];
                arr[c] = arr[root];
                arr[root] = temp;
                root = c;
                c = 2*root+1;
            }else{
                break;
            }
        }
    }
    public static void sort(int[] arr){
        for(int i=arr.length-1; i>=0; i--){
            adjust(arr,i,arr.length);
        }
        int end = arr.length-1;
        int temp = 0;
        while(end >=0){
            temp = arr[0];
            arr[0] = arr[end];
            arr[end] = temp;
            adjust(arr,0,end);
            end--;
        }
    }
}