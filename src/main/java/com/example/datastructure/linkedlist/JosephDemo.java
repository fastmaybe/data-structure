package com.example.datastructure.linkedlist;

/**
 * @Author: liulang
 * @Date: 2020/11/16 15:22
 *
 * 【1】 2 3 4 5 6
 * 1 2 3 4   【6】
 * 1 2 3     【6】
 * 【1】 2 3
 * 1   【3】
 * 1
 *
 * 【 双向循环链表 】 删除节点容易  维护起来复杂些
 *
 */
public class JosephDemo {

    public static void main(String[] args) {

        LinkedList1 list = new LinkedList1();

        for (int i = 1; i <= 1000; i++) {
            Person person = new Person(i, "person " + i);
            list.add(person);
        }

//        list.show();
       list.start(5,7);

    }





}

class LinkedList1{
    int size;
    Person head;
    Person tail;


    public void add(Person person){
        if (head == null){
            head = person;
            tail = head;
            head.next = tail;
            head.pre = tail;
            size++;
            return;
        }
//【此处画图 最清晰  】
       //首先拿到临时最后节点
       Person temptail = tail;
        // 新节点 画线   <----
        person.pre = temptail;
        //tail 游标 移动
        tail = person;
        //上节点next 从 ---》head 变为  ---》新tail(person)
        temptail.next = tail;
        //新尾结点 tail ---> head
        tail.next = head;

        // 更新头部 head 的 《---  为最新节点   此处很容易漏掉
        head.pre = tail;

        size++;
    }


    public void start(int beginNum,int countNum){
        //前置校验  暂忽略

        //移动下标 找到第一个报数的；
        Person die = head;
        for (int i = 0; i < beginNum-1; i++) {
            die = die.next;
        }

        while (true){

            if (size == 1){
                System.err.println(die+" 勝出");
                break;
            }

            //开始报数 移动countNum -1 的人 就出列
            for (int i = 0; i < countNum -1; i++) {
                die = die.next;
            }

            //die出列
            System.out.println(die+" 淘汰");

            //next更新
            die.pre.next = die.next;
            //pre更新
            die.next.pre = die.pre;


            size--;


            //从被杀死的下一位开始报数
            die=die.next;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }



    }

    public void show() {
        Person temp = head;

        while (true){
            System.out.println(temp);
                if (temp.next == head){
                    break;
                }
            //后移
            temp = temp.next;
        }
    }
}
 class Person{
    int num;
    String name;
    Person next;
    Person pre;

    public Person(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}'+"【"+pre.num+"----"+next.num+"】";
    }
}