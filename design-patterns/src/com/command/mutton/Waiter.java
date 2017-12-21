package com.command.mutton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Waiter.java
//  @ Date : 2016/9/29
//  @ Author : 
//
//

public class Waiter {
    private List<Command> commands = new ArrayList<>();

    public void setOrder(Command command) {
        if ("com.command.mutton.BakeChickenWingCommand".equals(command.getClass().getName())) {
            System.out.println("鸡翅没有了，请点别的烧烤吧");
        } else {
            commands.add(command);
            System.out.println("增加订单  " + command.getClass().getName() + "时间." + new Date());
        }
    }

    public void notify1() {
        for (Command command : commands) {
            command.excuteCommand();
        }
    }

}
