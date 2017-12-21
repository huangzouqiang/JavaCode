package com.Composite;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Leaf.java
//  @ Date : 2016/9/30
//  @ Author : 
//
//

public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    public void add(Component component) {
        System.out.println("没有子节点，不能新增子节点");
    }

    public void remove(Component component) {
        System.out.println("没有子节点，不能删除子节点");
    }

    public void display(int depth) {
        System.out.println(new String("-" + depth) + " " + name);
    }
}
