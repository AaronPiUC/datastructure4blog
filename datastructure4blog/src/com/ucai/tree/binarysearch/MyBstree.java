package com.ucai.tree.binarysearch;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class MyBstree <E extends Comparable<E>>{
   private class MyNode{
       E e;
       MyNode left, right;

       MyNode(E e){
           this.e = e;
           this.left = null;
           this.right = null;
       }
   }

   private MyNode root;

   private int size;

   public MyBstree(){
       this.root = null;
       this.size = 0;
    }

    public int getSize(){
       return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    //添加元素
    public void add(E e){
       if(root == null){
           root = new MyNode(e);
           size ++;
       }else{
           root = add(root, e);
       }

    }

    //判断存在
    public boolean contains(E e){
       return contains(root, e);
    }

    //前序遍历
    public void traversePrevious(){
        traversePre(root);
    }

    //前序遍历非递归
    public void traversePreviousNR(){
        Stack<MyNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()){
            MyNode cur = st.pop();
            doSomething(cur);
            if(cur.right != null){
                st.push(cur.right);
            }
            if(cur.left != null){
                st.push(cur.left);
            }

        }
    }

    public void traverserByFloor(){
       Queue<MyNode> q = new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
           MyNode mn  = q.remove();
           doSomething(mn);
           if(mn.left != null){
               q.add(mn.left);
           }
           if(mn.right != null){
               q.add(mn.right);
           }
       }
    }
    //中序遍历
    public void traverseMiddle(){
        traverseMid(root);
    }

    //后序遍历
    public void traversePostorder(){
        traversePro(root);
    }

    //寻找最小元素
    public E getMinValue(){
       if(size == 0){
           throw new IllegalArgumentException("Tree is Empty!");
       }
       MyNode mn = root;
       while(mn.left !=null){
           mn = mn.left;
       }
       return mn.e;
    }

    //寻找最大元素
    public E getMaxValue(){
        if(size == 0){
            throw new IllegalArgumentException("Tree is Empty!");
        }
        MyNode mn = root;
        while(mn.right !=null){
            mn = mn.right;
        }
        return mn.e;
    }

    //删除最小元素
    public E removeMin(){
        E min = getMinValue();
        removeMin(root);
        return min;
    }

    //删除最大元素
    public E removeMax(){
        E min = getMaxValue();
        removeMax(root);
        return min;
    }

    private MyNode removeMax(MyNode mn) {

       if(mn.right == null){
           MyNode mr = mn.left;
           mn.left = null;
           size --;
           return mr;
       }

       mn.right = removeMax(mn.right);
       return mn;

    }

    private MyNode removeMin(MyNode mn) {

        if(mn.left == null){
            MyNode mr = mn.right;
            mn.right = null;
            size --;
            return mr;
        }

        mn.left = removeMin(mn.left);
        return mn;

    }
    private void traversePre(MyNode n){
        if(n == null){
            return;
        }
        doSomething(n);

        if(n.left != null){
            traversePre(n.left);
        }
        if(n.right != null){
            traversePre(n.right);
        }
    }

    private void traverseMid(MyNode n){
        if(n == null){
            return;
        }
        if(n.left != null){
            traversePre(n.left);
        }
        doSomething(n);
        if(n.right != null){
            traversePre(n.right);
        }
    }

    private void traversePro(MyNode n){
        if(n == null){
            return;
        }
        if(n.left != null){
            traversePre(n.left);
        }
        if(n.right != null){
            traversePre(n.right);
        }
        doSomething(n);
    }

    private void doSomething(MyNode n){
        System.out.println("do service:"+ n.e);
    }

    private boolean contains(MyNode n, E e) {
        if(n == null){
            return false;
        }else{
            if(e.compareTo(n.e)==0){
              return true;
            } else if(e.compareTo(n.e)<0){
                return contains(n.left, e);
            } else{
                return contains(n.right, e);
            }
        }
   }

    private MyNode add(MyNode n, E e) {
        if (n == null) {
            size ++;
            return new MyNode(e);
        }

        if(e.compareTo(n.e) < 0){
            n.left = add(n.left, e);
        }else {
            n.right = add(n.right, e);
        }

        return n;
    }
}
