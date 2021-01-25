package com.example.datastructure.sort.bubbling;

import com.example.datastructure.sort.ArrUtil;

import java.util.Arrays;

/**
 * @Author: liulang
 * @Date: 2020/11/27 17:31
 */
public class Demo3 {

    public static void main(String[] args) {
        int[] arr = ArrUtil.create(80000);

        long a = System.currentTimeMillis();
        doBubSort(arr);
        long b = System.currentTimeMillis();

        System.err.println(b-a);
//        System.out.println(Arrays.toString(arr));
    }

    private static void doBubSort(int[] arr) {
        int needSortBorder = arr.length -1;

        int lastChangeIndex = 0;

        //外层控制回合
        for (int i = 0; i < arr.length-1; i++) {
            //冒泡
            int temp;
            boolean out = true;
            //初始化的无序 边界为 arr.length -1 即需要比较一直到 倒数第二个  （倒数第二个会和最后比较）

            for (int j = 0; j < needSortBorder; j++) {
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                    //如果一直都有交换 会将needSortIndex 置为 needSortIndex -1
                    //但是如果在后续几次比较 都没有交换needSortIndex 会停留在前几次 说明后面的已经是有序区域了
                    lastChangeIndex = j;

                    out = false;
                }
            }

            //一次循环完 更新无序边界
            needSortBorder = lastChangeIndex;

            if (out) break;
        }
    }
}
