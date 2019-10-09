package com.ucai.queue;

import com.ucai.array.MyArray;
import com.ucai.myinterface.MyQueueInterface;



public class MyArrayQueue<Element> implements MyQueueInterface<Element> {

    private MyArray<Element> arr;

    public MyArrayQueue(int capacity) {
        arr = new MyArray<>(capacity);
    }

    public MyArrayQueue() {
        arr = new MyArray<>();
    }

    @Override
    public int getSize() {
        return arr.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public void enqueue(Element element) {
        arr.addLast(element);
    }

    @Override
    public Element dequeue() {
        return arr.deleteFirst();
    }

    @Override
    public Element getFront() {
        return arr.getFirst();
    }

    @Override
    public String toString() {
        return "ArrayQueue: " + arr + "<----- tail of queue";
    }

    /**
     * 获取队列的容量
     */
    public int getCapacity() {
        return arr.getCapacity();
    }

    public static void main(String[] args) {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
