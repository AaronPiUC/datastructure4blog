package com.ucai.stack;

import com.ucai.array.MyArray;

public class Mystack<T> implements MyStackInterface<T> {
    MyArray<T> arr;

    public Mystack(int capacity) {
        arr = new MyArray<T>(capacity);
    }

    public Mystack() {
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
