package com.ucai.classload;

class Parent{
    static{
        System.out.println("Parent Initialization");
    }

    public static int value = 2;
}

class Son extends Parent{
    static {
        System.out.println("Son Initialization");
    }
}

public class ClassInitializationTest {
    public static void main(String[] args) {
        //System.out.println(Son.value);
        Son[] ps = new Son[10];
    }
}



