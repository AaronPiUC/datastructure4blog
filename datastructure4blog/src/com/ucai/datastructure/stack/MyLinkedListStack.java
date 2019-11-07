package com.ucai.datastructure.stack;

import com.ucai.datastructure.linkedlist.MyLinkedList;
import com.ucai.datastructure.myinterface.MyStackInterface;

public class MyLinkedListStack<T> implements MyStackInterface<T> {

    private MyLinkedList<T> myLinkedList;

    public MyLinkedListStack(){
        myLinkedList = new MyLinkedList<>();
    }

    @Override
    public int getSize() {
        return myLinkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return myLinkedList.isEmpty();
    }

    @Override
    public void push(T element) {
        myLinkedList.addFirst(element);
    }

    @Override
    public T pop() {
        return myLinkedList.removeFirst();
    }

    @Override
    public T peek() {
        return myLinkedList.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        sb.append("stack top");
        sb.append(myLinkedList);
        return sb.toString();
    }
}
