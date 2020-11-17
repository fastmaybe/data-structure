package com.example.datastructure.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: liulang
 * @Date: 2020/11/16 17:26
 */
public class JosephDemo2 {


    public static void main(String[] args) {

//        countQueue(20,7,5);

        //方式二
        LinkedList2 list2 = new LinkedList2();
        for (int i = 1; i <= 1000; i++) {
            Person2 person2 = new Person2(i);
            list2.add(person2);
        }

        list2.start(5,7);

    }


    /**
     * 方式一  计数取模
     * @param personNumber
     * @param number
     * @param begin
     */
    public static void countQueue(int personNumber,int number,int begin){
        //1.把人放到队列中
        Queue<Integer> persons =  new LinkedList<Integer>();
        for (int i = 0; i < personNumber; i++) {
            persons.add(i+1);
        }

        for (int i = 0; i < begin-1; i++) {
            Integer person1 = persons.poll();
            persons.add(person1);
        }


        //2.算法
        int counts = 0;//计数器
        while (!persons.isEmpty()) {

                //1.出队列
                Integer person = persons.poll();
                //2.计数器++
                counts++;

                //3.判断
                if (counts % number == 0 ) {
                    //是,打印
                    System.out.println(person);
                } else {
                    //不是,继续入队列
                    persons.add(person);
                }



        }
    }

}


/**
 * 方式二  单向循环链表
 */
class LinkedList2{

    private Person2 head;

   private Person2 curPerson;

    public void add(Person2 person){
        //记录当前加入后的最新的 节点

        if (head == null){
            head = person;
            head.next = head;
            curPerson = head;
        }else {
            //游标
            curPerson.next = person;
            person.next = head;
            //下移
            curPerson = person;
        }

    }


    /**
     *
     * @param begin 从第几个开始
     * @param num //数几个数
     */
    public void start(int begin, int num){
        //由于是单向链表  因此 需要一个辅助指针 指向每次删除的节点的上一个节点 否则无法完成删除
        //首次开始时候 这个辅助指针就是 curPerson
        Person2 helper = this.curPerson;
        Person2 dieNode = this.head;

        //dieNode 每次指向的节点就是需要删除的
        //找到首次开始报数的人；移动 begin -1 次
        for (int i = 0; i < begin -1; i++) {
            helper=helper.next;
            dieNode = dieNode.next;
        }

        while (true){

            //当helper dieNode 相等  代表最后一个
            if (helper == dieNode){
                System.err.println(dieNode.num);
                break;
            }

            //开始报数 num 个数 移动num-1 次
            for (int i = 0; i < num-1; i++) {
                helper = helper.next;
                dieNode = dieNode.next;
            }

            System.out.println(dieNode.num);

            //删除dieNode
            helper.next = dieNode.next;
            dieNode = dieNode.next;
        }



    }

}




class Person2{
    //编号
    int num;

    //下一节点
    Person2 next;

    public Person2(int num) {
        this.num = num;
    }
}
