package com.example.datastructure.recursion.migong;

/**
 * @Author: liulang
 * @Date: 2020/11/20 10:25
 *
 * 迷宫 问题  递归demo
 */
public class RecursionDemo1 {

    /**
     * 墙体 设置为1
     * 走过的 设置为2
     * 行不通的 设置为3
     * @param args
     */
    public static void main(String[] args) {
        //初始化一个迷宫
        int row = 10;
        int line = 10;
        int[][] migong = new int[row][line];

        for (int i = 0; i <row; i++) {
            migong[i][0] = 1;
            migong[i][line-1] = 1;
        }
        for (int i = 0; i <line; i++) {
            migong[0][i] = 1;
            migong[row-1][i] = 1;
        }

        for (int i = 2; i <line/2; i++) {
            migong[3][i] = 1;
        }



        for (int i = row/3; i <row; i++) {
            migong[i][5] = 1;
        }



        System.out.println("初始化=========");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                System.out.print(migong[i][j]+" ");
            }
            System.out.println();
        }
         setWay(migong, 1, 1);

        System.out.println("结束后=========");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                int value = migong[i][j];
                if (value==2){
                    System.err.print(migong[i][j]+" ");
                }else {
                    System.out.print(migong[i][j]+" ");
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }

    }

     static boolean setWay(int[][] migong,int row,int line){
        if (row==8 && line == 8){
//            migong[row][line] = 2;
            return true;
        }
        if (migong[row][line] == 1){
            return false;
        }
        if (migong[row][line]==2||migong[row][line] == 3){
            return false;
        }
        migong[row][line]=2;


        //右
        boolean b2 = setWay(migong, row, line + 1);
        if (b2) return b2;
        //上
        boolean b1 = setWay(migong, row - 1, line);
        if (b1) return b1;

        boolean b3 = setWay(migong, row, line - 1);
        if (b3) return b3;
         //下
         boolean b = setWay(migong, row + 1, line);
         if (b) return b;

        migong[row][line]=3;
        return false;

    }
}
