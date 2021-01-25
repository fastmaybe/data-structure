package com.example.datastructure.sort.insert;

import com.example.datastructure.sort.ArrUtil;

import java.util.Arrays;

/**
 * 插入排序：内排法（内存排序）
 * 基本思想：把n个元素 看成一个有序和n-1个无序表;开始有序表只有一个元素 即arr[0];每次从无序表取出
 *      一个元素插入到有序表 和有序表比较 放入适当位置
 * @Author: liulang
 * @Date: 2020/11/30 14:33
 */
public class Demo1 {

    public static void main(String[] args) {
        int[] arr = ArrUtil.create(800000);
//        System.out.println(Arrays.toString(arr));
        long a = System.currentTimeMillis();
        sort(arr);
        long b = System.currentTimeMillis();
        System.err.println(b-a);
//        System.out.println(Arrays.toString(arr));

    }

    static void sort(int[] arr){

        //外层控制循环 需要插入多少次
        for (int i = 1; i < arr.length; i++) {

            int insertValue = arr[i];
            int insertIndex = i;//假设i 就是需要插入的未知 插入的数值就是有序表最大的值

            //寻找插入的位置 此处 insertIndex-1 需要大于0 否则后面的arr[insertIndex-1] 会索引越界
            while (insertIndex - 1 >= 0 && insertValue < arr[insertIndex - 1]) {
                //当insertIndex = 1 进来后 且insertValue<arr[0]
                //将比较的值 及insertIndex-1 位置的值 后移
                arr[insertIndex] = arr[insertIndex-1];
                //然后更新插入位置的索引 --
                insertIndex --;
            }
            //退出循环 当找到位置后
            arr[insertIndex] = insertValue;
            //如果没有找到 其实说明insertIndex 没有变化  就是 最初假设需要插入的位置 最开始的i

        }

    }

    /**
     * 推导
     */
    static void sort2(){
        int[] arr1 = new int[]{4,3,2};

        // 第一次 带插入的数据为arr[1] 假设需要插入的
         int insertValue = arr1[1];
         int insertIndex = 1;
         //和前面比较  首先索引不越界 然后插入的值 必前面的小
        if (insertIndex >=0 && insertValue<arr1[insertIndex -1]){
            //前面的值向后移动一位步长
            arr1[insertIndex] = arr1[insertIndex -1];
            //继续找更前面的比较
            insertIndex--;
        }

        //退出循环后 如果找到了
        arr1[insertIndex] = insertValue;



    }
}
