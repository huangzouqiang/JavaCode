package com.visitor.manAndWoman;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Success.java
//  @ Date : 2016/9/27
//  @ Author : 
//
//

public class Success extends Status {
    public void getManResponse(Man man) {
        System.out.println("男人成功背后多半有一个伟大的女人"+man.getClass().getName());
    }

    public void getWomanResponse(Woman woman) {
        System.out.println("女人成功被轰多半有一个不争气的男人"+woman.getClass().getName());
    }
}