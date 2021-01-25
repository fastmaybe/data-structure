package com.example.datastructure.sort.bubbling;

import java.util.Arrays;

/**
 * @Author: liulang
 * @Date: 2020/11/27 17:06
 *
 * version2 标识
 */
public class Demo2 {

    public static void main(String[] args) {

        int[] arr = Demo1.create(10);

        doBubSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void doBubSort(int[] arr) {

        //外层控制回合
        for (int i = 0; i < arr.length-1; i++) {
            //冒泡
            int temp;
            boolean out = true;
            for (int j = 0; j < arr.length -1 -i; j++) {
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                    out = false;
                }
            }

            if (out) break;
        }
    }
}
