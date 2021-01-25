package com.example.datastructure.sort.shell;

import com.example.datastructure.sort.ArrUtil;

import java.util.Arrays;

/**
 * 希尔排序：
 *
 * 假设看插入排序的问腿：arr[2,3,4,5,6,1] 当插入1时候 后移的次数明显增多 多效率有影响
 *
 * 希尔排序也是 【插入排序】；是简单插入排序改进后的版本  也称为  【缩小增量排序】
 *
 * 基本思想：记录按照下表的一定增量分组；对每组使用直接插入排序算法排序；随着增量减小；每组包含的关键词越来越多
 *          ；当增量减为 1 ；文件被分为一组 排序完成。
 *
 * @Author: liulang
 * @Date: 2020/11/30 15:17
 */
public class Demo1 {

    public static void main(String[] args) {
//        tuidao();

        int[] arr = ArrUtil.create(8000000);
//        System.out.println(Arrays.toString(arr));
        long begin = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
//        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr){

        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                //比较五组内的数据 大小交换 //步长为5
                //需要插入的数据为arr[i]
                int insertValue = arr[i];
                int insertIndex = i;

                //找到需要插入的位置 insertIndex - 5>= 0 防止索引越界 且插入位置比前一个小 （前一个为步长前一个）
                while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {
                    //将前一个 移位 步长
                    arr[insertIndex] = arr[insertIndex-gap];
                    insertIndex -= gap;
                }
                //退出后 insertIndex 变化了 也是直接插入  没有变化说明 这个地方本就是应该插入的
                arr[insertIndex] = insertValue;

            }

        }


    }

    /**
     * 推导演绎
     */
    static void tuidao(){

        int[] arr = new int[] { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };


        //第一次 arr.length /2 = 5组

        for (int i = 0+5; i < arr.length; i++) {
                //比较五组内的数据 大小交换 //步长为5
            //需要插入的数据为arr[i]
            int insertValue = arr[i];
            int insertIndex = i;

            //找到需要插入的位置 insertIndex - 5>= 0 防止索引越界 且插入位置比前一个小 （前一个为步长前一个）
            while (insertIndex - 5 >= 0 && insertValue < arr[insertIndex - 5]) {
                //将前一个 移位 步长
                arr[insertIndex] = arr[insertIndex-5];
                insertIndex -= 5;
            }
            //退出后 insertIndex 变化了 也是直接插入  没有变化说明 这个地方本就是应该插入的
            arr[insertIndex] = insertValue;

        }

        System.out.println(Arrays.toString(arr));
        //第二次  5 / 2 = 2 分为两组
        for (int i = 0+2; i < arr.length; i++) {
            //比较五组内的数据 大小交换 //步长为5
            //需要插入的数据为arr[i]
            int insertValue = arr[i];
            int insertIndex = i;

            //找到需要插入的位置 insertIndex - 2>= 0 防止索引越界 且插入位置比前一个小 （前一个为步长前一个）
            while (insertIndex - 2 >= 0 && insertValue < arr[insertIndex - 2]) {
                //将前一个 移位 步长
                arr[insertIndex] = arr[insertIndex-2];
                insertIndex -= 2;
            }
            //退出后 insertIndex 变化了 也是直接插入  没有变化说明 这个地方本就是应该插入的
            arr[insertIndex] = insertValue;

        }
        System.out.println(Arrays.toString(arr));

        //最后一次 可以发现最后一次 就是简单 插入的方法 com.example.datastructure.sort.insert.Demo1.sort 步长为1
        //第二次  2 / 2 = 1 分为两组
        for (int i = 0+1; i < arr.length; i++) {
            //比较五组内的数据 大小交换 //步长为5
            //需要插入的数据为arr[i]
            int insertValue = arr[i];
            int insertIndex = i;

            //找到需要插入的位置 insertIndex - 2>= 0 防止索引越界 且插入位置比前一个小 （前一个为步长前一个）
            while (insertIndex - 1 >= 0 && insertValue < arr[insertIndex - 1]) {
                //将前一个 移位 步长
                arr[insertIndex] = arr[insertIndex-1];
                insertIndex -= 1;
            }
            //退出后 insertIndex 变化了 也是直接插入  没有变化说明 这个地方本就是应该插入的
            arr[insertIndex] = insertValue;

        }
        System.out.println(Arrays.toString(arr));
    }
}
