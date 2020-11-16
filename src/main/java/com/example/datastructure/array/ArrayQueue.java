package com.example.datastructure.array;


import java.util.Arrays;

/**
 * @Author: liulang
 * @Date: 2020/11/12 13:48
 */
public class ArrayQueue {


    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>(3);

        System.out.println(queue.get());

        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.put(4);

        System.out.println(queue.get());
        queue.put(4);
    }



    /**
     * 数组实现循环队列 先进先出 不扩容
     */
    static class Queue<T>{
        private int front = 0;  //头部元素
        private int tail = 0; //指向尾部元素的 下一未知
        private T[] data;
        private int size; //维护有效的数据 size


        public Queue(int size){
            this.data = (T[]) new Object[size];
        }

        public boolean put(T item){
            if (isFull()) {
                System.err.println("队列已经满了");
                System.err.println(Arrays.toString(data));
                return false;
            }
            //判断是否已经满了
            data[tail] = item;
            tail  = (++tail) % data.length;
            size++;
            System.out.println(Arrays.toString(data));
            return true;
        }

        public T get(){
            if (isEmpty()){
                System.err.println("队列是空的");
                System.err.println(Arrays.toString(data));
                return null;
            }
            T datum = data[front];
             front =  (++front) % data.length;
            size--;
            System.out.println(Arrays.toString(data));
            return datum;
        }


        private boolean isEmpty(){
            return tail ==front && size == 0;
        }


        private boolean isFull(){
          return   tail  ==  front && size == data.length;
        }


    }

}
