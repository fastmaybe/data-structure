package com.example.datastructure.sort;

/**
 * @Author: liulang
 * @Date: 2020/11/30 14:03
 */
public class ArrUtil {

   public static int[] create(int size){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random()*size);
        }
        return arr;
    }
}
