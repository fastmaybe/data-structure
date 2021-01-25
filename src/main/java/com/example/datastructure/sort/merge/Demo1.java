package com.example.datastructure.sort.merge;

import com.example.datastructure.sort.ArrUtil;

import java.util.Arrays;

/**归并排序：利用归并的思想实现的排序方法；是 经典的分治策略（分 将问题 分成一些小的问题 然后递归求解 ；治 将
 *      分的阶段的结构答案  修补在一起
 * ）
 *
 * @Author: liulang
 * @Date: 2020/11/30 18:23
 */
public class Demo1 {

    public static void main(String[] args) {
        int[] arr = ArrUtil.create(8);
        System.out.println(Arrays.toString(arr));

        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));

    }

    static void mergeSort(int[] arr,int left ,int right,int[] temp){
        if (left < right){
            int mid = (left + right) / 2;
            //向左递归
            mergeSort(arr, left, mid, temp);
            //向右递归
            mergeSort(arr, mid+1, right, temp);

            //合并
            merge(arr,left,mid,right,temp);
        }

    }




    static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left; //初始化i 左边有序序列的出事索引
        int j = mid+1;  // 右边有序序列的出事索引
        int saveIndex = 0; //临时数组的初始索引

        //先把左右 比较然后放入临时数组里面 直到一边放完
        while (i <= mid && j <= right){

           if (arr[i] <= arr[j]){
                temp[saveIndex] = arr[i];
                saveIndex++;
                i++;
           }else {
                temp[saveIndex] = arr[j];
                saveIndex++;
                j++;
           }
        }
        //然后将 剩下一边没有放入的 依次放入
        while (i <= mid){
            temp[saveIndex] = arr[i];
            i++;
            saveIndex++;
        }

        while (j <= right){
            temp[saveIndex] = arr[j];
            j++;
            saveIndex++;
        }

        //将temp 复制到 arr
        //将temp数组的元素拷贝到arr
        //		//注意，并不是每次都拷贝所有
        int t = 0;
        while (left <= right){
            arr[left] = temp[t];
            t++;
            left++;
        }
    }
}
