// 归并算法的中心是归并两个已经有序的数组。归并两个有序数组A和B，就生成了第三个有序数组C。
// 数组C包含数组A和B的所有数据项。

// 1.非递归方法：
/**
 * 传入两个有序数组a和b，返回一个排好序的合并数组
 * @param a
 * @param b
 * @return
 */
public static int[] sort(int[] a,int[] b){
    int[] c = new int[a.length+b.length];
    int aNum = 0,bNum = 0,cNum=0;
    while(aNum<a.length && bNum < b.length){
        if(a[aNum] >= b[bNum]){//比较a数组和b数组的元素，谁更小将谁赋值到c数组
            c[cNum++] = b[bNum++];
        }else{
            c[cNum++] = a[aNum++];
        }
    }
    //如果a数组全部赋值到c数组了，但是b数组还有元素，则将b数组剩余元素按顺序全部复制到c数组
    while(aNum == a.length && bNum < b.length){
        c[cNum++] = b[bNum++];
    }
    //如果b数组全部赋值到c数组了，但是a数组还有元素，则将a数组剩余元素按顺序全部复制到c数组
    while(bNum == b.length && aNum < a.length){
        c[cNum++] = a[aNum++];
    }
    return c;
}

// 2.递归方法：

public static int[] mergeSort(int[] c,int start,int last){
    if(last > start){
        //也可以是(start+last)/2，这样写是为了防止数组长度很大造成两者相加超过int范围，导致溢出
        int mid = start + (last - start)/2;
        mergeSort(c,start,mid);//左边数组排序
        mergeSort(c,mid+1,last);//右边数组排序
        merge(c,start,mid,last);//合并左右数组
    }
    return c;
}
 
public static void merge(int[] c,int start,int mid,int last){
    int[] temp = new int[last-start+1];//定义临时数组
    int i = start;//定义左边数组的下标
    int j = mid + 1;//定义右边数组的下标
    int k = 0;
    while(i <= mid && j <= last){
        if(c[i] < c[j]){
            temp[k++] = c[i++];
        }else{
            temp[k++] = c[j++];
        }
    }
    //把左边剩余数组元素移入新数组中
    while(i <= mid){
        temp[k++] = c[i++];
    }
    //把右边剩余数组元素移入到新数组中
    while(j <= last){
        temp[k++] = c[j++];
    }
     
    //把新数组中的数覆盖到c数组中
    for(int k2 = 0 ; k2 < temp.length ; k2++){
        c[k2+start] = temp[k2];
    }
}