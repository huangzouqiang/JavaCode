package com.ChainOfResponsibilty;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ConcreteHandle3.java
//  @ Date : 2016/9/29
//  @ Author : 
//
//




public class ConcreteHandle3 extends Handle {
	public void handleRequest(int request) {
	    if (request > 20) {
            System.out.println("请求被处理       " + this.getClass().getName());
        } else {
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
	}
}