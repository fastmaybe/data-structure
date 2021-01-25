package com.example.datastructure.sort.select;

import com.example.datastructure.sort.ArrUtil;

import java.util.Arrays;

/**
 * 选择排序基本思想：
 * 从arr[0] - arr[n-1]当中选取最小值；与arr[0]交换
 * 第二次从arr[1] - arr[n-1]选择最小值 与arr[1]交换 以此类推
 *
 * @Author: liulang
 * @Date: 2020/11/30 14:01
 */
public class Demo1 {


    public static void main(String[] args) {
        int[] arr = ArrUtil.create(800000);
//        System.out.println(Arrays.toString(arr));
        long a = System.currentTimeMillis();
        sort(arr);
        long b = System.currentTimeMillis();
        System.out.println(b-a);
//        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr){


        //外层循环控制需要交换多少次  比如长度为3的数组 需要找出最小放在0  如何找出来放在1 就完成了 需要3-1 两次
        for (int i = 0; i < arr.length-1; i++) {
            //i 代表需要找出当前轮回最小值 需要放置的位置
            //minIndex 找出来的最小值的索引  一次交换 不是冒泡多次交换
            //假设最小值就是当前自己的位置的值
            int temp = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                //j从i开始
                if (arr[j] < temp){
//                    //交换
//                    int tem = arr[j];
//                    arr[j] = temp;
//                    temp = tem;
                    minIndex = j;//记录此次的值
                    temp = arr[j];
                }
            }

            //一轮结束后 minIndex 变化了  交换
            if (minIndex != i){
                arr[minIndex]=  arr[i];
                arr[i] = temp;
            }

        }

    }

    /**
     * 写法结构虽然对了 但是却用冒泡的思想
     * @param arr
     */
    static void sortNo(int[] arr){



        //外层循环控制需要交换多少次  比如长度为3的数组 需要找出最小放在0  如何找出来放在1 就完成了 需要3-1 两次
        for (int i = 0; i < arr.length-1; i++) {
            //i 代表需要找出当前轮回最小值 需要放置的位置
            //minIndex 找出来的最小值的索引
            //假设最小值就是当前自己的位置的值
            int temp = arr[i];
            for (int j = i; j < arr.length; j++) {
                //j从i开始
               if (arr[j] < temp){
                   //交换
                   int tem = arr[j];
                   arr[j] = temp;
                   temp = tem;
               }
            }

            //一轮结束后
            arr[i] = temp;
        }

    }
}
