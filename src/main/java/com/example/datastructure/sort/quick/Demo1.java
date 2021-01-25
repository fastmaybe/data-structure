package com.example.datastructure.sort.quick;

import com.example.datastructure.sort.ArrUtil;

import java.util.Arrays;

/**
 * 快速排序:对冒泡排序的一种改进 通过一趟排序 将数据分为 两个独立的部分 其中一部分
 *          比另外一部分所有数据都小 然后以此类推 整个过程可以递归进行
 * @Author: liulang
 * @Date: 2020/12/1 14:51
 */
@SuppressWarnings("all")
public class Demo1 {

    public static void main(String[] args) {

//        int[] arr = new int[]{8,8,4,0,-5,-7,1};
        int[] arr = ArrUtil.create(800000);
//        System.out.println(Arrays.toString(arr));
        long a = System.currentTimeMillis();
        sort(arr,0,arr.length-1);
        long b = System.currentTimeMillis();
        System.out.println(b-a);
//        System.out.println(Arrays.toString(arr));

    }

    static void sort(int[] arr,int left,int right){

      int l= left; //左offset
      int r = right; //右offset
      int mid = (l + r) / 2;
      int midValue = arr[mid];
      int temp = 0;

      while (l < r){
          //左边找出来 比midValue大的
          while (arr[l] < midValue) {
              l++;
          }
          //右边
          while (arr[r] > midValue) {
              r--;
          }
          //假设数组左边都是比 midValue小 右边都是比其大 则 l++ r-- 然后 当 l ->mid <-r 逼近mid
          if (l >= r) {
              break;
          }
        //交换
          temp = arr[l];
          arr[l] = arr[r];
          arr[r] = temp;

          if(arr[l] == midValue) {
              r --;
          }
          if(arr[r] == midValue) {
              l ++;
          }

      }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r){
            sort(arr, left, r);
        }
        if (right > l){
            sort(arr, l, right);
        }
    }


    public static void quickSort(int[] arr,int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while( l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while( arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while(arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if( l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if(arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if(arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if(right > l) {
            quickSort(arr, l, right);
        }


    }
}
