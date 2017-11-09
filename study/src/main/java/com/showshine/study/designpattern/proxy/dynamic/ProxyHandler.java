package com.showshine.study.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理模式代理类。用来代理和封装真实主题
 * 
 * @author showshine
 * @since 1.0
 * @version 2017年11月9日
 */
public class ProxyHandler implements InvocationHandler {
	
	private Object proxied;//保存真实业务对象
	
	/*public ProxyHandler(Object proxied) {
		this.proxied = proxied;
	}*/
	
	public ProxyHandler() {
		
	}
	
	/**
	 * 返回动态代理类的对象,这样用户才可以利用代理类对象去操作真实对象
	 * 
	 * @param obj 包含有真实业务实现的对象
	 * @return 返回代理对象
	 */
	public Object getProxy(Object obj) {
		
		this.proxied = obj;// 保存真实业务对象
		
		return Proxy.newProxyInstance(
				obj.getClass().getClassLoader(), // 定义代理类的类加载器
				obj.getClass().getInterfaces(), // 代理类要实现的接口列表
				this);// 指派方法调用的调用处理程序
	}

	/**
	 * @param proxy 表示需要代理的对象
	 * @param method 表示要操作的方法
	 * @param args 方法所需要传入的参数(可能没有,为null.也可能有多个)
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 在转调具体目标对象之前，可以执行一些功能处理

		// 转调具体目标对象的方法
		return method.invoke(proxied, args);

		// 在转调具体目标对象之后，可以执行一些功能处理
	}

}