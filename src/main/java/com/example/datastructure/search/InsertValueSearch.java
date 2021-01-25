package com.example.datastructure.search;

/**
 * @Author: liulang
 * @Date: 2020/12/2 16:53
 *  插值查找 【个人感觉叫差值好点 就是数学运用 线性差值】
 */

public class InsertValueSearch {

    public static void main(String[] args) {

        int[] arr = { 1, 8, 10, 89,1000,1000, 1234 };

        int i = insertValueSearch(arr, 0, arr.length - 1, 1234);

        System.out.println(i);

    }

    static int insertValueSearch(int[] arr,int left,int right,int find){
         //跳出条件
        if (left > right || find < arr[0] || find > arr[arr.length -1 ]){
            return  -1;
        }
        //求，mid自适应
        int mid = left +  (find - arr[left]) * ((right - left) / (arr[right] - arr[left]));

        int midVal = arr[mid];

        if (find > midVal){
            return insertValueSearch(arr, mid+1, right, find);
        }else if (find < midVal){
            return insertValueSearch(arr, left, mid-1, find);
        }else {
            return mid;
        }


    }
}
