package com.showshine.study.designpattern.observer.jdk;

/**
 * Jdk自带观察者测试类
 * 
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @version 2017-11-09 14:19
 * 
 */
public class JdkObserverTest {

	public static void main(String[] args) {
		//首先定义一个观察者去观察  
		JdkConcreateSubject sub = new JdkConcreateSubject();  
          
        //定义张三，写代码  
        Worker zs = new Worker("张三", "写代码");  
        //告诉观察者，我需要知道老板什么时候来的  
        sub.registerObserver(zs);  
          
        //定义李四，管后勤  
        Worker ls = new Worker("李四", "管后勤");  
        //告诉观察者，我需要知道老板什么时候来的  
        sub.registerObserver(ls);  
          
        //定义王五，写代码  
        Worker ww = new Worker("王五", "秘书");  
        //告诉观察者，我需要知道老板什么时候来的  
        sub.registerObserver(ww);  
          
        //这时候，老板来了，告诉所有的人，老板来了  
        //这个没有设置changed  
        System.out.println("jdk changed not config");  
        sub.notifyObservers();  
        System.out.println("jdk changed config");  
        sub.setChanged();  
        sub.notifyAllObserver();  
	}
	
}
