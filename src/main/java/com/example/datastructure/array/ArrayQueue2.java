package com.example.datastructure.array;

import java.util.Arrays;

/**
 *
 * 用java 数组  实现循环队列的方法：
 *
 * 1、增加一个属性size用来记录目前的元素个数。目的是当head=rear的时候，通过size=0还是size=数组长度，来区分队列为空，或者队列已满。
 *
 * 2、数组中只存储数组大小-1个元素，保证rear转一圈之后不会和head相等，也就是队列满的时候，rear+1=head，中间刚好空一个元素。
 *   【0  0  1  2  0】 front =2  tail = 4   4+5-2 % 5 = 2
 *   [1  0  1  2  3 ] front = 2  tail = 1  1+5-2 % 5 =4
  */

/**
 *
 *      [  方式一  ]
 *
 * @Author: liulang
 * @Date: 2020/11/12 17:04
 */
public class ArrayQueue2 {


    static class Queue2<T>{
        private int front = 0;  //头部元素
        private int tail = 0; //指向尾部元素的 下一未知
        private T[] data;
        private int size; //维护有效的数据 size
        private int level = 2; //扩容因子
        private final int minSize = 6; //最小值 小于4 不缩容

        public Queue2(int size){
          data = (T[]) new Object[size];
        }

        private boolean isFull(){
            return front == tail && size == data.length;
        }

        private boolean isEmpty(){
            return front == tail && size == 0;
        }

        //扩容 或者缩容 flag true => 缩小
        private void resize(int newSize,boolean flag){
//            if (newSize < minSize && flag) return;
            System.err.println("resize:"+newSize);
            T[] newData = (T[]) new Object[newSize];
            for (int i = 0; i < size; i++) {
                newData[i] = data[ (i+front) % data.length ];
            }
            data = newData;
            front =0;
            tail = size;
        }



        public boolean put(T e){
            if (isFull()){
                resize(level * data.length,false);
            }
            data[tail] = e;
            tail = ++tail % data.length;
            size++;
            return true;
        }

        public T get(){
            if (isEmpty()){
                return null;
            }
            T datum = data[front];
            data[front] = null;//置空
            front = ++front % data.length;
            size--;
           if (size < data.length/level){
               resize(data.length / level,true);
           }
            return datum;
        }

        @Override
        public String toString() {
            return "Queue{" +
                    "front=" + front +
                    ", tail=" + tail +
                    ", data=" + Arrays.toString(data) +
                    ", size=" + size +
                    ", level=" + level +
                    ", minSize=" + minSize +
                    '}';
        }
    }


    public static void main(String[] args) {
        Queue2<Integer> queue2 = new Queue2<>(2);
        queue2.put(1);
        queue2.put(2);
        queue2.put(3);
        System.out.println(queue2);

        for (int i = 0; i < 10; i++) {
            queue2.put(i);
        }
        System.out.println(queue2);

        for (int i = 0; i < 15; i++) {
            System.out.println(queue2.get());
        }
        System.out.println(queue2);
    }
}
