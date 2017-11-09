package com.showshine.study.designpattern.proxy.dynamic;

/**
 * 动态代理模式真实主题。真实实现业务逻辑的类
 * 
 * @author showshine
 * @since 1.0
 * @version 2017年11月9日
 */
public class RealSubject implements Subject {
	
	public void doSomething(String someone) {
		System.out.println(someone + " call doSomething()");
	}
}