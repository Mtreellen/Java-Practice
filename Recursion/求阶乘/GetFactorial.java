/**
 * 问题：求一个数的阶乘：n!
 * n! = n*(n-1)*(n-2)*......1
 */
 
// 1.for 循环：

/**
 * 0！=1  1！=1
 * 负数没有阶乘,如果输入负数返回-1
 * @param n
 * @return
 */

public static int getFactorialFor(int n){
    int temp = 1;
    if(n >=0){
        for(int i = 1 ; i <= n ; i++){
            temp = temp*i;
        }
    }else{
        return -1;
    }
    return temp;
}

// 2. 递归 n! = n*(n-1)！

/**
 * 0！=1  1！=1
 * 负数没有阶乘,如果输入负数返回-1
 * @param n
 * @return
 */
public static int getFactorial(int n){
    if(n >= 0){
        if(n==0){
            System.out.println(n+"!=1");
            return 1;
        }else{
            System.out.println(n);
            int temp = n*getFactorial(n-1);
            System.out.println(n+"!="+temp);
            return temp;
        }
    }
    return -1;
}