package com.example.datastructure.sort.radix;

import com.example.datastructure.sort.ArrUtil;

import java.util.Arrays;

/**
 * 基数排序 （桶排序）：
 * 基数排序 属于稳定排序  基数排序是  桶排序的发展
 *
 * 基本思想：将所有数值统一为 同样长度的位数长度，数位较短的前面 补0
 * 然后依次将从低位 到高位
 *          【典型的 空间 换时间】
 * 1）桶排序是稳定的；
 * 2）桶排序是常见排序算法中最快的一种，大多数情况下比快排和归并排序还要快
 * 3）桶排序非常快但是也非常消耗空间，典型的以空间换时间，基本上是最耗内存的一种排序算法。
 *
 * // 基数排序全部为 正数
 * //假设存在负数  个人思路： 全部加一个 最小值 让其称为正数  或者 正数和 负数分为两段排序
 * @Author: liulang
 * @Date: 2020/12/2 15:01
 *
 * 【80000000】 80000000数据时候 OutOfMemoryError: Java heap space
 *
 *  创建10 个桶 一个int 4个字节   10 * 80000000 * 4 (byte)/ 1024 (kb)/ 1024 (m) /1024  = 2.9G
 */
public class Demo1 {

    public static void main(String[] args) {
        int[] arr = ArrUtil.create(80000000);
//        System.out.println(Arrays.toString(arr));

        long a = System.currentTimeMillis();


        sort(arr);
        long b = System.currentTimeMillis();
        System.out.println(b-a);

//        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr){
        //1 找出最大值 补齐
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
        }
        //最大数是几位数
        int maxLength = (max + "").length();

        // 定义一个二维数组 标识10个桶
        // 每个桶就是一个一维数组 一维数组 长度 为arr的长度 因为不知道这个桶会放多少数据
        //
        int[][] buckets = new int[10][arr.length];

        //为了记录每个桶 实际存放了多少个数据 顶一个一个一维数组 来记录
        int[] bucketElementCounts = new int[10];

        //maxLength
        for (int i = 0,n = 1; i < maxLength; i++,n *= 10) {
            //第一次各位 第二次十位....以此类推
            for (int j = 0; j < arr.length; j++) {
                //取出来 改位数的 值
                int off = arr[j] / n % 10;
                buckets[off][bucketElementCounts[off]] = arr[j];
                bucketElementCounts[off]++;
            }
            //一次排序完成 按照桶的顺序 （一维数组的下标 依次取出数据 放入原来数组）
            int index = 0;
            //遍历每一个桶
            for (int b = 0; b < bucketElementCounts.length; b++) {
                //取出桶的数据
                for (int d = 0; d < bucketElementCounts[b]; d++) {
                       arr[index] = buckets[b][d];
                       index++;
                }
                //取出数据后 将桶 清理干净  下一轮需要用
                bucketElementCounts[b] = 0;
            }

        }


    }


}
