package com.visitor.manAndWoman;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : failure.java
//  @ Date : 2016/9/27
//  @ Author : 
//
//

public class Failure extends Status {
    public void getManResponse(Man man) {
        System.out.println("男人失败时喝闷酒,谁都不用劝");
    }

    public void getWomanResponse(Woman woman) {
        System.out.println("女人失败是听悲伤的歌，谁都劝不了。");
    }
}
