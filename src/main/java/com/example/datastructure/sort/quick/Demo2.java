package com.example.datastructure.sort.quick;

import com.example.datastructure.sort.ArrUtil;

import java.util.Arrays;
import java.util.jar.JarEntry;

/**
 * 快速排序
 * @Author: liulang
 * @Date: 2020/12/2 13:44
 */
public class Demo2 {


    public static void main(String[] args) {


        int[] arr = ArrUtil.create(80000000);
//        int[] arr = new int[]{7, 1, 2, 3, 2, 6, 5, 6};
//        System.out.println(Arrays.toString(arr));
        long a = System.currentTimeMillis();
        sort(arr,0,arr.length-1);
        long b = System.currentTimeMillis();
        System.out.println(b-a);
//        System.out.println(Arrays.toString(arr));
    }


    static void sort(int[] arr,int left,int right){
        if (left > right){
            //递归最后 只有一个数字 递归后 61行代码是这样的 sort（arr,0 ,0-1）,sort（arr,1 ,0）
            return;
        }

        int split = arr[left];// 基准值 分割值 取左边这个
        int l = left;
        int r = right;
        int temp = 0;


        while (l != r) {
            //从右边开始 注意从右边开始 找出来比 分割值小的 索引
            // 至于为什么 需要先从右边开始 因为是目前是从小到大 排序
            // 当i== j 退出时候 需要将split 归位 也就如果 右边已经比split小的 r--会向 l靠近
            // 当退出时候  i <- j  j移动到了l 此时arr[l]的值是 上次交换后的 比 split小的值 arr[i] 和 split（即arr[left]）交换

            while (arr[r] >= split && l < r){
                //左移
                r--;
            }
            //然后找出左边 比分割值大的 索引
            while (arr[l] <= split && l < r){
                //右移
                l++;
            }
            if (l < r) {
                temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
        }
        //退出时候 l== r就是r 和 l相遇了
        arr[left] = arr[l];
        arr[l] = split;
        //继续处理左边的
        sort(arr, left, l-1);
        //继续处理右边的
        sort(arr, l+1, right);

    }

}
