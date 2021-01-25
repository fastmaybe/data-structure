package com.example.datastructure.sort.bubbling;

import java.util.Arrays;

/**
 * @Author: liulang
 * @Date: 2020/11/27 16:43
 */
public class Demo1 {

    public static void main(String[] args) {

        int[] arr1= new int[]{9,5,7,4};
        doBubSort(arr1);
//        System.out.println(Arrays.toString(arr1));

        //测试多数据
        int[] arr = create(80000);
        long be = System.currentTimeMillis();
        doBubSort(arr);
        long end = System.currentTimeMillis();

        System.out.println((end-be)/1000);

        System.out.println(Arrays.toString(arr));


    }

    static int[] create(int size){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random()*size);
        }
      return arr;
    }



  private   static void doBubSort(int[] arr){


        for (int j = 0; j < arr.length-1; j++) {
            int temp;
            //第一轮 找到最大的放最后
            for (int i = 0; i < arr.length-1-j; i++) {
                if (arr[i]>arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }

    }

    /**
     * 图解
     * @param arr
     */
   private static void bubSort(int[] arr){

        int temp;
        //第一轮 找到最大的放最后
        for (int i = 0; i < arr.length-1; i++) {
           if (arr[i]>arr[i+1]){
               temp = arr[i];
               arr[i] = arr[i+1];
               arr[i+1] = temp;
           }
        }

        //第一轮 找到第二大的放倒数第二
        for (int i = 0; i < arr.length-2; i++) {
            if (arr[i]>arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        //第3轮 找到第二大的放倒数第二
        for (int i = 0; i < arr.length-3; i++) {
            if (arr[i]>arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }



    }

}
