package com.ChainOfResponsibilty;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ConcreteHandle2.java
//  @ Date : 2016/9/29
//  @ Author : 
//
//

public class ConcreteHandle2 extends Handle {
    public void handleRequest(int request) {
        if (request > 10 && request < 20) {
            System.out.println("请求被处理       " + this.getClass().getName());
        } else {
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
    }
}
