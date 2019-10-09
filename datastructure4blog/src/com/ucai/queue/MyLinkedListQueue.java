package com.ucai.queue;

import com.ucai.myinterface.MyQueueInterface;

public class MyLinkedListQueue<E> implements MyQueueInterface<E> {

    /**
     * 每个节点的封装
     */
    private class Node {
        /**
         * 节点元素值
         */
        E element;
        /**
         * 指向的下一个节点
         */
        Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element) {
            this(element, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private Node head, tail;
    private int size;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) {
        // 从队列尾部入队
        if (tail == null) {
            // tail为null说明之前没有元素
            tail = new Node(element);
            // 第一个元素，head和tail应该都指向它
            head = tail;
        } else {
            // 之前有元素，tail后移以为直线加入地Node
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列不能为空！");
        }
        // 从队头删除元素(出队)
        // 临时保存头结点
        Node retNode = head;
        // 头节点指针后移
        head = head.next;
        // 把原来的头结点置空
        retNode.next = null;
        if (head == null) {
            // 如果头结点指针指向null,说明队列中没元素了,tail也该为null
            tail = null;
        }
        size--;
        return retNode.element;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列不能为空！");
        }
        return head.element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front");
        Node cur = head;
        while (cur != null) {
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedListQueue<Integer> queue = new MyLinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
