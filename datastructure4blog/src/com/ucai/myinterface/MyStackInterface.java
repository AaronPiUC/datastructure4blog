package com.ucai.myinterface;

public interface MyStackInterface<T> {

    //获取Stack的元素数
    int getSize();

    //判断Stack是否为空
    boolean isEmpty();

    //像Stack中添加元素
    void push(T element);

    //弹出栈顶元素
    T pop();

    //获取栈顶元素但是不弹出
    T peek();
}
