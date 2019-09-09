import java.util.Stack;

public class QuickSort {
    public static void quickSort(int[] arr){
        quick(arr,0,arr.length-1);
    }
    private static void quick(int[] arr,int low, int high){
        if(low >= high){
            return;
        }
        //优化：插入排序
        if(high-low+1>=10){
            insertSort(arr,low,high);
            return;
        }
        //优化：三数取中
        takeThreeNumber(arr,low,high);
        int p = partion(arr,low,high);
        quick(arr,low,p-1);
        quick(arr,p+1,high);
    }
    private static int partion(int[] arr,int low, int high){
        int temp = arr[low];
        while (low<high){
            while (low<high && arr[high]>=temp){
                high--;
            }
            if(low == high){
                break;
            }else if(low < high){
                arr[low] = arr[high];
            }
            while (low<high && arr[low]<=temp){
                low++;
            }
            if(low == high){
                break;
            }else if(low <high){
                arr[high] = arr[low];
            }
        }
        arr[low] = temp;
        return low;
    }
    private static void insertSort(int[] arr,int low, int high){
        for(int i=low; i<=high; i++){
            int temp = arr[i];
            int j= i-1;
            for(; j>=0 && arr[j]>temp; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }
    private static void takeThreeNumber(int[] arr,int low,int high){
        int mid = (low + high)>>1;
        if(arr[mid] < arr[low]){
            swap(arr,mid,low);
        }
        if(arr[mid] > arr[high]){
            swap(arr,mid,high);
        }
        if(arr[low] < arr[mid]){
            swap(arr,mid,low);
        }
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //非递归实现
    public static void sort(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = arr.length-1;
        int p = partion(arr,low,high);
        if(p-low>1){
            stack.push(low);
            stack.push(p-1);
        }
        if(high-p >1){
            stack.push(p+1);
            stack.push(high);
        }
        while(!stack.empty()){
            high = stack.pop();
            low = stack.pop();
            p = partion(arr,low,high);
            if(p-low>1){
                stack.push(low);
                stack.push(p-1);
            }
            if(high-p >1){
                stack.push(p+1);
                stack.push(high);
            }
        }
    }
}