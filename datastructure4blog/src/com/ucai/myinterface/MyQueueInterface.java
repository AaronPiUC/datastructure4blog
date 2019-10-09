package com.ucai.myinterface;

public interface MyQueueInterface<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();


}
