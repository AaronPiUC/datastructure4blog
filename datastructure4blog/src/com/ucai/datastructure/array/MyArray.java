package com.ucai.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 创建订制数组
 */
public class MyArray<T> {
    //存储数据
    private T[] data;
    //当前元素个数
    private int size;
    //容量
    private int capacity;

    //构造函数
    public MyArray(int capacity) {
        this.capacity = capacity;
        this.data = (T[])new Object[capacity];
        this.size = 0;
    }
    public MyArray(){
        this(10);
    }

    //获取当前元素个数
    public int getSize(){
        return this.size;
    }

    //判断是否为空
    public boolean isEmpty(){
        return this.size == 0;
    }

    //临界检查（是否满）
    public void precheck(){
        if(this.size == this.data.length){
            throw new IllegalArgumentException("容量已经满，无法添加");
        }
    }

    //在某一位置插入元素
    public void insert(int index, T e){
        precheck();
        if(index < 0 || index > size){
            throw new IllegalArgumentException("非法参数。无法操作");
        }
        //位置之后统一向后移动一个
        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        this.size ++;
    }

    //向数组头加元素
    public void addFirst(T e){
        insert(0, e);
    }

    //向数组尾加元素
    public void addLast(T e){
        insert(size, e);
    }

    //修改
    public void update(int index, T e){
        //先判断越界
        if(index < 0 || index > size){
            throw new IllegalArgumentException("非法参数。无法操作");
        }
        this.data[index] = e;
    }

    //获取某一位置的元素
    public T get(int index){
        //先判断越界
        if(index < 0 || index > size){
            throw new IllegalArgumentException("非法参数。无法操作");
        }
        return this.data[index];
    }

    //获取最后的元素
    public T getLast() {
        return get(size - 1);
    }

    //获取第一个元素
    public T getFirst() {
        return get(0);
    }

    //找到元素第一次出现的位置
    public int findFirstMeet(T e){
        for (int i = 0; i < size; i++) {
            if(data[i] == e){
                return i;
            }
        }
        //没找到就返回-1
        return -1;
    }

    //找到元素所有出现的位置
    public ArrayList<Integer> find(T e){
        ArrayList<Integer> placeList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if(data[i] == e){
                placeList.add(i);
            }
        }
        return placeList;
    }

    //删除某一位置的元素
    public T delete(int index){
        //先判断越界
        if(index < 0 || index > size){
            throw new IllegalArgumentException("非法参数。无法操作");
        }
        T ret = data[index];
        //index后的元素全部向前
        for (int i = index; i < size -1; i++) {
            data[i] = data[i+1];
        }
        return ret;
    }

    //删除数组头元素
    public T deleteFirst(){
        return delete(0);
    }

    //删除数组尾元素
    public T deleteLast(){
        return delete(size);
    }

    //删除某个元素(第一次出现的地方)
    public T deleteElement(T e){
        int index= findFirstMeet(e);
        return delete(index);
    }

    //删除数组中这个元素所有
    public T deleteElementAll(T e){
        ArrayList<Integer> placeList = find(e);
        if(placeList.size()>0) {
            for (int p : placeList) {
                delete(p);
            }
        }
        return e;
    }

    //判断包含元素
    public boolean contain(T e){
        for (int i = 0; i < size; i++) {
            if(data[i] == e){
                return true;
            }
        }
        return false;
    }

    //获取容量
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Array:" +
                " capacity=" + capacity +
                ", size=" + size +
                ", data=" + Arrays.toString(data);
    }
}
