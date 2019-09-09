public class MergeSort {
    public static void mergeSort(int[] arr){
        mergeSortHelper(arr,0,arr.length-1);
    }

    private static void mergeSortHelper(int[] arr, int start, int end) {
        if(start >= end){
            return;
        }
        int mid = (start+end) >> 1;
        mergeSortHelper(arr,start,mid);
        mergeSortHelper(arr,mid+1,end);
        merge(arr,start,mid,end);
    }
    private static void merge(int[] arr, int start,int mid, int end) {
        int[] temp = new int[arr.length];
        int tempIndex = start;
        int start2 = mid+1;
        int i = start;
        while (start<=mid && start2<=end){
            if(arr[start] <= arr[start2]){
                temp[tempIndex++] = arr[start++];
            }else {
                temp[tempIndex++] = arr[start2++];
            }
        }
        if(start<=mid){
            System.arraycopy(arr,start,temp,tempIndex,mid-start+1);
        }
        if(start2<=end){
            System.arraycopy(arr,start2,temp,tempIndex,end-start2+1);
        }
        System.arraycopy(temp,i,arr,i,end-i+1);
    }

}