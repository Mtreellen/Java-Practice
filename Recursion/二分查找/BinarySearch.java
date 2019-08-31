// 前提：二分查找的数组是有序的

// 非递归方式：

/**
 * 找到目标值返回数组下标，找不到返回-1
 * @param array
 * @param key
 * @return
 */
public static int findTwoPoint(int[] array,int key){
    int start = 0;
    int last = array.length-1;
    while(start <= last){
        int mid = (last-start)/2+start;//防止直接相加造成int范围溢出
        if(key == array[mid]){//查找值等于当前值，返回数组下标
            return mid;
        }
        if(key > array[mid]){//查找值比当前值大
            start = mid+1;
        }
        if(key < array[mid]){//查找值比当前值小
            last = mid-1;
        }
    }
    return -1;
}

// 递归方式：

public static int search(int[] array,int key,int low,int high){
    int mid = (high-low)/2+low;
    if(key == array[mid]){//查找值等于当前值，返回数组下标
        return mid;
    }else if(low > high){//找不到查找值，返回-1
        return -1;
    }else{
        if(key < array[mid]){//查找值比当前值小
            return search(array,key,low,mid-1);
        }
        if(key > array[mid]){//查找值比当前值大
            return search(array,key,mid+1,high);
        }
    }
    return -1;
}

// 递归的二分查找和非递归的二分查时间复杂度都为O(logN)
// 递归的二分查找更加简洁，但速度会比非递归的慢。