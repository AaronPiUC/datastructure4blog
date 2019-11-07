package com.ucai.datastructure.stack;

import com.ucai.datastructure.array.MyArray;
import com.ucai.datastructure.myinterface.MyStackInterface;

public class MyArrayStack<T> implements MyStackInterface<T> {

    private MyArray<T> arr;

    public MyArrayStack(int capacity) {
        arr = new MyArray<T>(capacity);
    }

    public MyArrayStack() {
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
    public void push(T element) {
        arr.addLast(element);
    }

    @Override
    public T pop() {
        return arr.deleteLast();
    }

    @Override
    public T peek() {
        return arr.getLast();
    }

    @Override
    public String toString() {
        return "ArrayStack: " + arr + "<----top of stack";
    }

    //获取栈的容量
    public int getCapacity() {
        return arr.getCapacity();
    }
}
