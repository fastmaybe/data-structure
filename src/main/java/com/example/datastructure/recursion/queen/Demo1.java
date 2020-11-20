package com.example.datastructure.recursion.queen;

/**
 * @Author: liulang
 * @Date: 2020/11/20 14:19
 */

/**
 * 参考资料 https://blog.csdn.net/weixin_46008168/article/details/105627554
 * 八皇后 问题 理论上棋牌用二维数组 代表棋盘  但是 可以使用一维数组  来编程  比如  arrr[0] = 1 代表第一行 第二列 ；数组索引代表行 数组值代表列
 *
 */
public class Demo1 {

    static int size = 8;
    static int[] arr = new int[size];
    static int count = 0;//

    public static void main(String[] args) {

        put(0);
        System.err.println(count);
    }

    static void put(int row){
        if (row == size){
            //数组已经放满了8个数
            count++;
            out();
            return;
        }
        for (int i = 0; i < size; i++) {
            //从第一列开始放置
            arr[row] = i;
            if (check(row)){
                //能放 就继续下一行
                put(row+1);
            }
        }
    }

    /**
     * 检查 能不能放
     * @param row
     * @return
     */
    private static boolean check(int row) {

        for (int i = 0; i < row; i++) {
            //如果 第row+1行 的列数 和 某一行的列数相同  返回false
            if (arr[i] == arr[row]) return false;

            //检查 斜对角  对角线 判断两点是不是对角线  判断其 横坐标距离 和 纵坐标距离 是不是一样。
            if (row-i == Math.abs(arr[row] - arr[i])) return false;
        }

        return true;
    }

    static void out(){
        for (int i = 0; i < size; i++) {
            System.out.printf("[%d行, %d列]  ",i,arr[i]);
        }
        System.out.println();
    }


}
