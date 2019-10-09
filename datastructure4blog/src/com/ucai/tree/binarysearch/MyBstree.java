package com.ucai.tree.binarysearch;

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

    //先序遍历
    public void traversePrevious(){
        traversePre(root);
    }

    //中序遍历
    public void traverseMiddle(){
        traverseMid(root);
    }

    //后序遍历
    public void traversePostorder(){
        traversePro(root);
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
