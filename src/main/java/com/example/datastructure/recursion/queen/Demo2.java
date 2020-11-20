package com.example.datastructure.recursion.queen;


/**
 * @Author: liulang
 * @Date: 2020/11/20 14:58
 */
public class Demo2 {
    static int[][] arr = new int[8][8];
    static int count= 0;


    public static void main(String[] args) {
        put(0);
        System.err.println(count);

    }

    private static void put(int row) {
        if (row == 8){
            //完成了一次 情况
            count++;
            out();
            return ;
        }
        int cols = arr[row].length;

        for (int col = 0; col < cols; col++) {
            //判断 row行 j列位置能不能放

            //从第一列开始放置  //检查 check 能不能放
            boolean check = check(row, col);

            if (check){
                //满足条件 将皇后放上去
                arr[row][col] = 1;

                //开始放下一行
                 put(row + 1);

                /**
                 * 重点 此处什么含义呢
                 * 主要因为 二维数组 放置皇后后  标识为了1   而检查某个位置能不能放  依赖这个数据
                 * ===假设成功了 row == 8 ： 递归回溯后 需要将此位置  置为 0； 还需要进行下一种情况的 统计
                 * ===假设最后失败了没有走到 row == 8：递归回溯后 需要将此位置  置为0 拿走皇后 避免后面检查 受到干扰
                 *
                 * 此位置在递归 结束后 ；白话解释  假设递归是一座城  这是在出城的路上
                 */
                arr[row][col] = 0;
            }
        }

    }



    /**
     * 判断row+1 的 col列能不能放
     * @param row
     * @param col
     * @return
     * 因为row是一次递增放的 需要检查列 和斜线
     */
    private static boolean check(int row, int col) {
        //判断前面的是否和现在的冲突
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                    //找到前row行的 位置的列
                if (arr[i][j] == 1){
                    //这一列已经放过 不能同行同列同斜线  不能满足不在同列
                    //不满足列
                    if (col == j) return false;
                    // 在一条斜线 坐标轴里面 就是横坐标的距离 等于纵坐标的距离
                    if (row-i == Math.abs(col-j)) return false;

                }
            }
        }
        return true;
    }

    private static void out() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1){
                    System.out.printf("[%d行, %d列]  ",i,j);

                }
            }
        }
        System.out.println();
    }


}
