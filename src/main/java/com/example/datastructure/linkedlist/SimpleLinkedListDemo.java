package com.example.datastructure.linkedlist;

/**
 * @Author: liulang
 * @Date: 2020/11/16 11:21
 *
 *
 * 单项链表   有头节点  无头节点
 *          头插法  每次放在最前面  比如有头结点  newNode.next = head.next
 *                                              head.next = newNode;
 *          尾插法  每次放在尾部  链表顺序和插入顺序一直。
 */
public class SimpleLinkedListDemo {


    public static void main(String[] args) {


        SimpleLinked<Object> list = new SimpleLinked<>();

        list.put("simple");
        list.put("double");
        list.put(null);
        list.put(null);
        list.del("simple");
        list.del(null);
        list.show();
    }
}

/**
 * 尾插法
 */
class SimpleLinked<T>{
    private  Node head ;

    public SimpleLinked() {
        head = new Node();
    }
    public boolean put(T data){

        //找到尾部节点
         Node temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            //后移
            temp = temp.next;
        }
        temp.next = new Node<T>(data);
        return true;
    }

    //删除某个节点
    public boolean del(T data){
        //找到待删除节点的上一个节点
           Node temp = head;
        while (true){
            if (temp.next.item == data){
                break;
            }
            //后移
            temp = temp.next;
        }
        //删除
        temp.next = temp.next.next;
        return true;
    }

    public void show(){
        Node temp = head.next;
        while (true){
           if (temp==null){
               break;
           }
            System.out.println(temp.toString());
            //后移
            temp = temp.next;
        }
    }

    private static class Node<T> {
        T item;
        Node<T> next;

        Node() {}

        public Node(T data) {
            this.item = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    '}';
        }
    }



}

