package com.showshine.study.designpattern.proxy.dynamic;

/**
 * 动态代理模式主题接口。 定义代理类和真实主题的公共对外方法，也是代理类代理真实主题的方法
 * 
 * @author showshine
 * @since 1.0
 * @version 2017年11月9日
 */
public interface Subject {

	public void doSomething(String someone);
}
