package com.ucai.datastructure.linkedlist;

public class MyLinkedList<E> {
    //构造一个内部类，Node
    private class Node{
        E e;
        Node next;

        public Node(E e, Node next){
        this.e = e;
        this.next = next;
    }

    public Node(E e){
        this(e, null);
    }

    public Node(){
        this(null, null);
    }
}
    //头结点
    private Node dummyHead;
    //容量
    private int size;
    //默认给一个初始化的构造函数
    public MyLinkedList(){
        this.dummyHead = null;
        size = 0;
    }
    //获取当前容量
    public int getSize(){
        return this.size;
    }

    //判断是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向第index个项后添加一个元素e
    public void add(int index, E e){
        if(index < 0 && index >size){
            throw  new IllegalArgumentException("Illegal Arguments");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;

    }

    //向头结点添加元素
    public void addFirst(E e){
        add(0, e);
    }

    //在链表末端添加元素
    public void addLast(E e){
        add(size, e);
    }

    //获取某位置的元素
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Illegal Arguments");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获取首元素
    public E getFirst(){
        return get(0);
    }

    //获取尾元素
    public E getLast(){
        return get(size);
    }

    //更新某位置的元素
    public void set(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Illegal Arguments");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查看某个元素是否存在
    public boolean contains(E e){
        Node n = dummyHead;
        while(n != null) {
            if(n.e.equals(e)){
                return true;
            }
            n = n.next;
        }
        return false;
    }

    //在链表中删除元素
    public E delete(int index){
        Node n = dummyHead;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        Node del = n.next;
        n.next = del.next;
        del.next = null;
        size--;
        return del.e;
    }

    //删除第一个元素
    public E removeFirst(){
        return delete(0);
    }

    //删除最后一个元素
    public E removeLast(){
        return delete(size);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(Node cur = dummyHead.next; cur.next != null; cur = cur.next){
            sb.append(cur.e);
            if(cur.next!= null){
                sb.append("->");
            }
        }
        return sb.toString();
    }

}
