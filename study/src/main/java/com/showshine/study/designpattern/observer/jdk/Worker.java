package com.showshine.study.designpattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 一个观察对象。注册对象须实现jdk自带的OBserver接口，并在update里面进行相应的响应事件操作
 * 
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2017-11-09 15:57
 */
public class Worker implements Observer, DisplayWork {  
  
    private String name;  
    private String des;  
      
    public Worker(String name, String des) {  
        super();  
        this.name = name;  
        this.des = des;  
    }  
  
  
    @Override  
    public void display() {  
        System.out.println("我在" + des + "了！");  
    }  
  
  
    public String getName() {  
        return name;  
    }  
  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
  
    @Override  
    public void update(Observable o, Object arg) {  
        System.out.println("老板来了，" + name + "好好干活啦！");  
        this.display();  
    }  
} 