package com.example.datastructure.search;

/**
 * @Author: liulang
 * @Date: 2020/12/2 16:49
 *  线性查找
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = { 1, 9, 11, -1, 34, 89 };// 没有顺序的数组
        seqSearch(arr,6);
    }

    private static int seqSearch(int[] arr, int valve) {
        //就是逐步查找
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valve){
                return i;
            }
        }
        return -1;

    }
}
