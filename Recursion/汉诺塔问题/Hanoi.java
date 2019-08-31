/** 
 * 汉诺塔问题是由很多放置在三个塔座上的盘子组成的一个古老的难题。所有盘子的直径是不同的，
 * 并且盘子中央都有一个洞使得它们刚好可以放在塔座上。所有的盘子刚开始都放置在A 塔座上。
 * 这个难题的目标是将所有的盘子都从塔座A移动到塔座C上，每次只可以移动一个盘子，并且任何
 * 一个盘子都不可以放置在比自己小的盘子之上。
 */
 
 /**
 * 汉诺塔问题
 * @param dish 盘子个数(也表示名称)
 * @param from 初始塔座
 * @param temp 中介塔座
 * @param to   目标塔座
 */
public static void move(int dish,String from,String temp,String to){
    if(dish == 1){
        System.out.println("将盘子"+dish+"从塔座"+from+"移动到目标塔座"+to);
    }else{
        move(dish-1,from,to,temp);//A为初始塔座，B为目标塔座，C为中介塔座
        System.out.println("将盘子"+dish+"从塔座"+from+"移动到目标塔座"+to);
        move(dish-1,temp,from,to);//B为初始塔座，C为目标塔座，A为中介塔座
    }
}

// 简单来说，跟把大象放进冰箱的步骤一样，递归算法为：

//  1)从初始塔座A上移动包含n-1个盘子到中介塔座B上。

//　2)将初始塔座A上剩余的一个盘子（最大的一个盘子）放到目标塔座C上。

//　3)将中介塔座B上n-1个盘子移动到目标塔座C上。