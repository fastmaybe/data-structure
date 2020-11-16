package com.example.datastructure.array;

/**
 * @Author: liulang
 * @Date: 2020/11/10 15:01
 */
public class ArrayBaseDemo {



    public static void main(String[] args) {

        //初始化二维数组
        int[][] array  = new int[11][11];
        array [1][2] = 1;
        array[2][4] =2;

        System.err.println("===========二维数组初始化========");
        for (int[] ints : array) {
            for (int item : ints) {
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }

        System.err.println("===========二维数组压缩========");

        //非0的数据统计
        int sum=0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array[i][j] != 0){
                    sum++;
                }
            }
        }

        //初始化稀疏数组
        int[][] sparseArray  = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        //填充非0
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array[i][j]!=0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }

        for(int i = 0;i<sparseArray.length;i++){
            System.out.printf("%d %d %d\t\r\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }

    }
}
