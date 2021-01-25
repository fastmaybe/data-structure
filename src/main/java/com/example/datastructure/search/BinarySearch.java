package com.example.datastructure.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liulang
 * @Date: 2020/12/2 16:33
 *
 * 【二分查找】 前提：数组是有序的
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 2, 6, 7, 8, 9, 10 };
        int i = binarySearch(arr, 0, arr.length - 1, 2);
        List<Integer> res = binarySearch2(arr, 0, arr.length - 1, 2);
        System.out.println(i);
        System.out.println(res);
    }

    /**
     * 最多找到一个
     * @param arr 数组
     * @param left  左
     * @param right 右
     * @param findValue 值
     * @return
     */
    static int binarySearch(int[] arr,int left, int right,int findValue){
        if (left > right){
            return -1;
        }

        int mid = (left + right) /2;
        int midValue = arr[mid];
        if (findValue > midValue){
            return binarySearch(arr, mid+1, right, findValue);
        }else if (findValue < midValue){
            return binarySearch(arr, left, mid-1, findValue);
        }else {
            return mid;
        }
    }

    /**
     * 找到 对应的下标
     * @param arr
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    static List<Integer>  binarySearch2(int[] arr,int left, int right,int findValue){
        if (left > right){
            return new ArrayList<>();
        }
        int mid = (left + right) /2;
        int midValue = arr[mid];
        if (findValue > midValue){
            return binarySearch2(arr, mid+1, right, findValue);
        }else if (findValue < midValue){
            return binarySearch2(arr, left, mid-1, findValue);
        }else {
            List<Integer> res = new ArrayList<>();
            int temp = mid+1;
            while (true){
                if (temp > arr.length-1 || arr[temp] != findValue){
                    break;
                }
                res.add(temp);
                temp++;
            }
            temp = mid-1;
            while (true){
                if (temp < 0 || arr[temp] != findValue){
                    break;
                }
                res.add(temp);
                temp--;
            }
            res.add(mid);
            return res;
        }

    }
}
